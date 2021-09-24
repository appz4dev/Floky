package me.appz4.beacon.resources;

import java.util.List;
import java.util.Locale;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import me.appz4.beacon.ApplicationContextProvider;
import me.appz4.beacon.firebase.FirebaseService;
import me.appz4.beacon.model.api.request.message.AddMessageRequest;
import me.appz4.beacon.model.api.request.message.DeleteThreadRequest;
import me.appz4.beacon.model.api.request.message.GetThreadRequest;
import me.appz4.beacon.model.api.request.message.GetThreadStatusRequest;
import me.appz4.beacon.model.api.request.message.GetThreadsRequest;
import me.appz4.beacon.model.api.response.message.AddMessageResponse;
import me.appz4.beacon.model.api.response.message.DeleteThreadResponse;
import me.appz4.beacon.model.api.response.message.GetThreadResponse;
import me.appz4.beacon.model.api.response.message.GetThreadStatusResponse;
import me.appz4.beacon.model.api.response.message.GetThreadsResponse;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.firebase.FirebaseNotificationData;
import me.appz4.beacon.model.model.Beacon;
import me.appz4.beacon.model.model.Message;
import me.appz4.beacon.model.model.Message.MessageStatuses;
import me.appz4.beacon.model.model.MessageThread;
import me.appz4.beacon.model.model.Token;
import me.appz4.beacon.model.model.User;
import me.appz4.beacon.model.model.UserWithToken;
import me.appz4.beacon.resources.annotations.JsonRequest;
import me.appz4.beacon.service.BeaconService;
import me.appz4.beacon.service.MessageService;
import me.appz4.beacon.service.UserService;

@RestController
@Path("/messages")
public class MessageResource extends BaseResource {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BeaconService beaconService;
	
	@Autowired
	private FirebaseService firebaseService;
	
	@JsonRequest
	@Path("/list")
	@POST
	public GetThreadsResponse getThreads(final GetThreadsRequest request) throws Exception {
		GetThreadsResponse response = new GetThreadsResponse();
		UserWithToken user = getUser(request);
		List<MessageThread> threads = messageService.getThreads(user.getUser().getId(), request.getSkip(), request.getLimit());
		for(MessageThread thread : threads) {
			if(thread.getBeaconId() != null) {
				Beacon beacon = beaconService.getBeaconBy(thread.getBeaconId());
				thread.setBeacon(beacon);
			}
			if(thread.getUserId() != null) {
				User fromUser = userService.getUser(thread.getUserId());
				thread.setFromUser(fromUser);
			}
			if(thread.getRecepientId() != null) {
				User toUser = userService.getUser(thread.getRecepientId());
				thread.setToUser(toUser);
			}
		}
		response.setThreads(threads);
		return response;
	}
	
	@JsonRequest
	@Path("/get")
	@POST
	public GetThreadResponse getThread(final GetThreadRequest request) throws Exception {
		GetThreadResponse response = new GetThreadResponse();
		UserWithToken user = getUser(request);
		isValid(request);
		MessageThread thread = messageService.getThreadBy(request.getThreadId());
		Long userId = user.getUser().getId();
		if(!userId.equals(thread.getUserId()) && !userId.equals(thread.getRecepientId())) {
			throw new ServiceException(Errors.ERROR_GENERAL);
		} 
		messageService.readMessages(thread);
		if(thread.getBeaconId() != null) {
			Beacon beacon = beaconService.getBeaconBy(thread.getBeaconId());
			thread.setBeacon(beacon);
		}
		if(thread.getUserId() != null) {
			User fromUser = userService.getUser(thread.getUserId());
			thread.setFromUser(fromUser);
		}
		if(thread.getRecepientId() != null) {
			User toUser = userService.getUser(thread.getRecepientId());
			thread.setToUser(toUser);
		}
		response.setThread(thread);
		return response;
	}
	
	@JsonRequest
	@Path("/delete")
	@POST
	public DeleteThreadResponse deleteThread(final DeleteThreadRequest request) throws Exception {
		DeleteThreadResponse response = new DeleteThreadResponse();
		UserWithToken user = getUser(request);
		isValid(request);
		messageService.deleteThread(user.getUser().getId(), request.getThreadId());
		return response;
	}
	
	@JsonRequest
	@Path("/add")
	@POST
	public AddMessageResponse addMessage(final AddMessageRequest request) throws Exception {
		AddMessageResponse response = new AddMessageResponse();
		UserWithToken user = getUser(request);
		isValid(request);
		Message message = new Message();
		message.setMessage(request.getMessage());
		MessageThread thread = null;
		if(request.getThreadId() != null) {
			thread = messageService.addToThread(request.getThreadId(), user.getUser().getId(), message);
		}
		else if(request.getToUserId() != null) {
			if(userService.isUserActive(request.getToUserId()) == null) {
				throw new ServiceException(Errors.ERROR_PARAMETER, "toUserId");
			}
			thread = messageService.createThread(user.getUser().getId(), request.getToUserId(), null, message);
		}
		if(thread != null) {
			Long fromUserId = thread.getUserId();
			Long toUserId = thread.getRecepientId();
			Long meUserId = user.getUser().getId();
			if(meUserId.equals(fromUserId)) {
				User toUser = userService.getUser(toUserId);
				if(toUser != null) {
					Token sendToken = userService.getActiveMessagingToken(toUserId);
					if(sendToken != null) {
						FirebaseNotificationData input = firebaseService.newMessage(ApplicationContextProvider.getApplicationContext(), Locale.ENGLISH, toUser.getUsername(), thread);
						firebaseService.sendNotification(meUserId, toUserId, null, sendToken.getToken(), input);
					}
				}
			}
			else if(meUserId.equals(toUserId)) {
				User toUser = userService.getUser(fromUserId);
				if(toUser != null) {
					Token sendToken = userService.getActiveMessagingToken(fromUserId);
					if(sendToken != null) {
						FirebaseNotificationData input = firebaseService.newMessage(ApplicationContextProvider.getApplicationContext(), Locale.ENGLISH, toUser.getUsername(), thread);
						firebaseService.sendNotification(meUserId, fromUserId, null, sendToken.getToken(), input);
					}
				}
			}
			response.setThreadId(thread.getId());
		}
		return response;
	}
	
	@JsonRequest
	@Path("/status")
	@POST
	public GetThreadStatusResponse getThreadStatus(final GetThreadStatusRequest request) throws Exception {
		GetThreadStatusResponse response = new GetThreadStatusResponse();
		UserWithToken user = getUser(request);
		long read = messageService.countAllMessagesBy(user.getUser().getId(), MessageStatuses.READ);
		long unread = messageService.countAllMessagesBy(user.getUser().getId(), MessageStatuses.UNREAD);
		response.setTotal(read+unread);
		response.setUnread(unread);
		return response;
	}
	
}
