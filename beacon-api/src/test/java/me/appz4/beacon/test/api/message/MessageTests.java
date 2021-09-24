package me.appz4.beacon.test.api.message;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.function.Predicate;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import me.appz4.beacon.model.api.request.message.AddMessageRequest;
import me.appz4.beacon.model.api.request.message.DeleteThreadRequest;
import me.appz4.beacon.model.api.request.message.GetThreadRequest;
import me.appz4.beacon.model.api.request.message.GetThreadsRequest;
import me.appz4.beacon.model.api.response.message.AddMessageResponse;
import me.appz4.beacon.model.api.response.message.DeleteThreadResponse;
import me.appz4.beacon.model.api.response.message.GetThreadResponse;
import me.appz4.beacon.model.api.response.message.GetThreadsResponse;
import me.appz4.beacon.model.model.MessageThread;
import me.appz4.beacon.test.api.ApiBaseTest;

public class MessageTests extends ApiBaseTest {

	private final String email = "JnK1UcLc3P@mailinator.com";
	
	private final String password = "2gmxAcmecLRPI4hT";
	
	private final Long targetUserId = 1L;
	
	private final String firstMessage = RandomStringUtils.randomAlphabetic(50);
	
	private final String secondMessage = RandomStringUtils.randomAlphabetic(50);
	
	private Long threadId;
	
	public MessageTests() {
		super(ApiBaseTest.BASEURL, ApiBaseTest.CLIENTID);
	}
	
	@Test(priority=-1)
	public void login() throws Exception {
		login(email, password);
	}
	
	private AddMessageResponse sendMessageHelper(Long threadId, Long userId, String message) throws Exception {
		AddMessageRequest request = new AddMessageRequest();
		request.setMessage(message);
		if(threadId != null) {
			request.setThreadId(threadId);
		}
		else if(userId != null) {
			request.setToUserId(userId);
		}
		AddMessageResponse response = post("messages/add", request, AddMessageResponse.class);
		hasError(response);
		assertNotNull(response.getThreadId());
		return response;
	}
	
	@Test(priority=1)
	public void sendMessage() throws Exception {
		AddMessageResponse response = sendMessageHelper(null, targetUserId, firstMessage);
		threadId = response.getThreadId();
	}
	
	@Test(priority=2)
	public void getThreads() throws Exception {
		GetThreadsRequest request = new GetThreadsRequest();
		GetThreadsResponse response = post("messages/list", request, GetThreadsResponse.class);
		hasError(response);
		assertNotNull(response.getThreads());
		assertEquals(response.getThreads().isEmpty(), false);
		Predicate<MessageThread> predicate = (i) -> i.getId().equals(threadId);	
		boolean found = response.getThreads().stream().anyMatch(predicate);
		assertTrue(found);
		response.getThreads().stream().filter(predicate).forEach((i) -> {
			assertEquals(i.getUnread(), new Integer(1));
			assertEquals(i.getMessage(), new Integer(1));
		});
	}
	
	private MessageThread getThreadHelper() throws Exception {
		GetThreadRequest request = new GetThreadRequest();
		request.setThreadId(threadId);
		GetThreadResponse response = post("messages/get", request, GetThreadResponse.class);
		hasError(response);
		MessageThread thread = response.getThread();
		assertNotNull(thread);
		return thread;
	}
	
	@Test(priority=3)
	public void getThread() throws Exception {
		MessageThread thread = getThreadHelper();
		assertEquals(thread.getMessages().isEmpty(), false);
		boolean found = thread.getMessages().stream().anyMatch((i) -> i.getMessage().equals(firstMessage));
		assertTrue(found);
		assertEquals(thread.getUnread(), new Integer(0));
		assertEquals(thread.getMessage(), new Integer(1));
	}
	
	@Test(priority=4)
	public void addToThread() throws Exception {
		sendMessageHelper(threadId, targetUserId, secondMessage);
	}
	
	@Test(priority=5)
	public void getThreadAgain() throws Exception {
		MessageThread thread = getThreadHelper();
		assertEquals(thread.getMessages().isEmpty(), false);
		boolean found = thread.getMessages().stream().anyMatch((i) -> i.getMessage().equals(secondMessage));
		assertTrue(found);
		assertEquals(thread.getUnread(), new Integer(0));
		assertEquals(thread.getMessage(), new Integer(2));
	}
	
	@Test(priority=Integer.MAX_VALUE)
	public void deleteThread() throws Exception {
		DeleteThreadRequest request = new DeleteThreadRequest();
		request.setThreadId(threadId);
		DeleteThreadResponse response = post("messages/delete", request, DeleteThreadResponse.class);
		hasError(response);
	}

}
