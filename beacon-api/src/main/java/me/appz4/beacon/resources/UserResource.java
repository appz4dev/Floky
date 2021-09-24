package me.appz4.beacon.resources;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.RandomStringUtils;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import me.appz4.beacon.amazon.AwsFileManager;
import me.appz4.beacon.model.api.ApiResponse;
import me.appz4.beacon.model.api.request.user.CheckUserRequest;
import me.appz4.beacon.model.api.request.user.CreateUserLocationRequest;
import me.appz4.beacon.model.api.request.user.DeleteRequest;
import me.appz4.beacon.model.api.request.user.EditUserRequest;
import me.appz4.beacon.model.api.request.user.ForgetPasswordRequest;
import me.appz4.beacon.model.api.request.user.GetNearUsersRequest;
import me.appz4.beacon.model.api.request.user.GetUserConfigRequest;
import me.appz4.beacon.model.api.request.user.LoginRequest;
import me.appz4.beacon.model.api.request.user.LogoutRequest;
import me.appz4.beacon.model.api.request.user.RegisterRequest;
import me.appz4.beacon.model.api.request.user.SaveMessagingTokenRequest;
import me.appz4.beacon.model.api.request.user.SaveUserConfigRequest;
import me.appz4.beacon.model.api.response.user.CheckUserResponse;
import me.appz4.beacon.model.api.response.user.CreateUserLocationResponse;
import me.appz4.beacon.model.api.response.user.DeleteResponse;
import me.appz4.beacon.model.api.response.user.EditUserResponse;
import me.appz4.beacon.model.api.response.user.ForgetPasswordResponse;
import me.appz4.beacon.model.api.response.user.GetNearUsersResponse;
import me.appz4.beacon.model.api.response.user.GetUserConfigResponse;
import me.appz4.beacon.model.api.response.user.LoginResponse;
import me.appz4.beacon.model.api.response.user.LogoutResponse;
import me.appz4.beacon.model.api.response.user.RegisterResponse;
import me.appz4.beacon.model.api.response.user.SaveUserConfigResponse;
import me.appz4.beacon.model.model.Beacon;
import me.appz4.beacon.model.model.BeaconLocation;
import me.appz4.beacon.model.model.BeaconStatus;
import me.appz4.beacon.model.model.ImageType;
import me.appz4.beacon.model.model.MessageThread;
import me.appz4.beacon.model.model.Position;
import me.appz4.beacon.model.model.Token;
import me.appz4.beacon.model.model.Token.Type;
import me.appz4.beacon.model.model.User;
import me.appz4.beacon.model.model.UserLocation;
import me.appz4.beacon.model.model.UserWithLocation;
import me.appz4.beacon.model.model.UserWithToken;
import me.appz4.beacon.resources.annotations.JsonRequest;
import me.appz4.beacon.service.BeaconService;
import me.appz4.beacon.service.ImageService;
import me.appz4.beacon.service.MessageService;
import me.appz4.beacon.service.UserService;

@RestController
@Path("/users")
public class UserResource extends BaseResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BeaconService beaconService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private AwsFileManager fileManager;
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	@POST
	public RegisterResponse register(final RegisterRequest request) throws Exception {
		RegisterResponse response = new RegisterResponse();
		getClient(request);
		isValid(request);
		userService.createUser(request.getEmail(), request.getUsername(), request.getPassword(), request.getFullname(), request.getPhone(), request.getIcon(), request.getPrivacy());
		UserWithToken u = userService.loginUser(request.getEmail(), request.getPassword());
		response.setUser(u);
		return response;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	@POST
	public LoginResponse login(final LoginRequest request) throws Exception {
		LoginResponse response = new LoginResponse();
		getClient(request);
		isValid(request);
		UserWithToken u = userService.loginUser(request.getEmail(), request.getPassword());
		response.setUser(u);
		return response;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/check")
	@POST
	public CheckUserResponse checkUserEmail(final CheckUserRequest request) throws Exception {
		CheckUserResponse response = new CheckUserResponse();
		getClient(request);
		response.setEmail(userService.checkUserEmail(request.getEmail()) == null);
		response.setUsername(userService.checkUserName(request.getUsername()));
		return response;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logout")
	@POST
	public LogoutResponse logout(final LogoutRequest request) throws Exception {
		LogoutResponse response = new LogoutResponse();
		UserWithToken user = getUser(request);
		userService.logoutUserByToken(user.getToken().getToken());
		return response;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@POST
	public DeleteResponse delete(final DeleteRequest request) throws Exception {
		DeleteResponse response = new DeleteResponse();
		UserWithToken user = getUser(request);
		userService.deleteUser(user.getUser().getId());
		return response;
	}
	
	@JsonRequest
	@Path("/edit")
	@POST
	public EditUserResponse edit(final EditUserRequest request) throws Exception {
		EditUserResponse response = new EditUserResponse();
		UserWithToken user = getUser(request);
		isValid(request);
		User update = user.getUser();
		if(request.getFullname() != null) {
			update.setFullname(request.getFullname());
		}
		if(request.getIcon() != null) {
			update.setIcon(request.getIcon());
		}
		if(request.getPhone() != null) {
			update.setPhone(request.getPhone());
		}
		if(request.getPassword() != null) {
			update.setPassword(request.getPassword());
		}
		userService.updateUser(update, request.getPassword());
		return response;
	}
	
	@JsonRequest
	@Path("/location/add")
	@POST
	public CreateUserLocationResponse createUserLocation(CreateUserLocationRequest request) throws Exception {
		CreateUserLocationResponse response = new CreateUserLocationResponse();
		UserWithToken user = getUser(request);
		isValid(request);
		userService.createUserLocation(user.getUser().getId(), request.getPosition());
		return response;
	}
	
	@JsonRequest
	@Path("/near")
	@POST
	public GetNearUsersResponse getNearUsers(GetNearUsersRequest request) throws Exception {
		GetNearUsersResponse response = new GetNearUsersResponse();
		UserWithToken user = getUser(request);
		isValid(request);
		//My lost beacons
		System.out.println("USER: "+user.getUser().getId());
		List<Beacon> beacons = beaconService.findAll(Restrictions.eq(Beacon.STATUS, BeaconStatus.LOST), Restrictions.eq(Beacon.USERID, user.getUser().getId()));
		System.out.println(beacons);
		if(!beacons.isEmpty()) {
			List<Long> userIds = new ArrayList<>();
			for(Beacon i : beacons) {
				List<BeaconLocation> locationsForBeacon = beaconService.getBeaconLocations(i.getId());
				for(BeaconLocation j : locationsForBeacon) {
					Long sawUserId = j.getUserId();
					if(sawUserId == user.getUser().getId()) continue;
					MessageThread hasExistingThread = messageService.getThreadFor(i.getId(), user.getUser().getId(), sawUserId);
					if(hasExistingThread != null) {
						if(!userIds.contains(j.getUserId())) {
							userIds.add(j.getUserId());
						}
					}
				}
			}
			if(!userIds.isEmpty()) {
				List<UserLocation> locations = userService.getNearUsers(request.getNorthEast(), request.getSouthWest(), userIds);
				List<Long> locationUserIds = new ArrayList<>();
				List<UserWithLocation> results = new ArrayList<>();
				for(UserLocation i : locations) {
					if(i.getUserId() == null) continue;
					UserWithLocation item = new UserWithLocation();
					if(locationUserIds.contains(i.getUserId())) {
						continue;
					}
					locationUserIds.add(i.getUserId());
					User u = userService.getUser(i.getUserId());
					if(u == null) continue;
					item.setUserId(u.getId());
					item.setPosition(new Position(i.getLatitude(), i.getLongitude()));
					item.setUsername(u.getUsername());
					item.setIcon(u.getIcon());
					results.add(item);
				}
				response.setResult(results);
			}
		}
		return response;
	}
	
	@JsonRequest
	@Path("/password")
	@POST
	public ForgetPasswordResponse forgetPassword(ForgetPasswordRequest request) throws Exception {
		ForgetPasswordResponse response = new ForgetPasswordResponse();
		getClient(request);
		isValid(request);
		User user = userService.checkUserEmail(request.getEmail());
		if(user != null) {
			String tempPass = userService.createTempPassword(user);
			userService.updateUser(user, tempPass);
			Map<String, Object> model = new HashMap<>();
			model.put("newPassword", tempPass);
			userService.sendMail("templates/password-mail.html", model, "Forget password", user.getEmail());
		}
		return response;
	}
	
	@JsonRequest
	@Path("/config/get")
	@POST
	public GetUserConfigResponse getConfig(GetUserConfigRequest request) throws Exception {
		GetUserConfigResponse response = new GetUserConfigResponse();
		UserWithToken user = getUser(request);
		response.setConfig(userService.getUserConfig(user.getUser()));
		return response;
	}
	
	@JsonRequest
	@Path("/config/save")
	@POST
	public SaveUserConfigResponse saveConfig(SaveUserConfigRequest request) throws Exception {
		SaveUserConfigResponse response = new SaveUserConfigResponse();
		UserWithToken user = getUser(request);
		isValid(request);
		userService.saveUserConfig(user.getUser(), request.getConfig());
		return response;
	}
	
	@JsonRequest
	@Path("/token")
	@POST
	public ApiResponse createToken(SaveMessagingTokenRequest request) throws Exception {
		UserWithToken user = getUser(request);
		isValid(request);
		Token.Type type = null;
		if(request.getType().equals("Android")) {
			type = Type.FIREBASE_ANDROID;
		}
		else {
			type = Type.FIREBASE_IOS;
		}
		userService.createMessagingToken(user.getUser(), type, request.getMessagingToken());
		return new ApiResponse();
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	@GET
	public ApiResponse test() throws Exception  {
		
		/*FirebaseNotification not = new FirebaseNotification();
		not.setTo("eo0B9mMxuYw:APA91bHew6ID-QC2uGFLhbO91f-nTN5O5ZGm7THQl3AZ0XOOmOdU6urjreT54UrYYHGmHxFveRoKWh96v2wEt9Y9Ixbgr8CSf3J_qVoJ8lz_0HbYCwJtFRdA-sCeVfzsaaALxVm_e0IK");
		FirebaseNotificationData data = new FirebaseNotificationData();
		data.setBody("What2");
		data.setNotificationType("type");
		data.setTitle("kewrke");
		//not.setData(data);
		not.setNotification(data);
		Client client = ClientBuilder.newBuilder().build();
		client.register(new LoggingFilter());
		Response response = client.target("https://fcm.googleapis.com/fcm/send")
				.request()
				.header("Authorization", "key=AAAAw4KfnrA:APA91bFEpoZO-uzbo_RxXQJJoJdYZr0cAdKp8UbPkcdoXs46H4evGYabk0MxqX9klWvhdpAJz0ghvfMtdEtcbR2uCNQfQ6ff3__1RQkMSZjbk_gccU8wZsBF-6C8BlEfqtE98nbGtbpn")
				.header("Content-Type", "application/json")
				.post(Entity.entity(not, MediaType.APPLICATION_JSON));
			String stringResponse = response.readEntity(String.class);
			System.out.println("RESPON: "+stringResponse);*/
		return new ApiResponse();
	}
	
	@Path("/test2")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse test2(final FormDataMultiPart request) throws Exception  {
		FormDataBodyPart clientIdPart = request.getField("clientId");
		FormDataBodyPart tokenPart = request.getField("token");
		FormDataBodyPart beaconIdPart = request.getField("beaconId");
		FormDataBodyPart filePart = request.getField("file");
		InputStream fileInputStream = filePart.getValueAs(InputStream.class);
		BufferedImage image = imageService.getImageFrom(fileInputStream);
		BufferedImage resized = imageService.createResizedFrom(image, ImageType.LARGE.getWidth(), ImageType.LARGE.getHeight());
		BufferedImage thumb = imageService.createSquareCroppedFrom(resized, ImageType.THUMBNAIL.getWidth());
		String generatedName = RandomStringUtils.randomAlphabetic(20);
		String generatedThumbName = generatedName+"_thumb";
		String result = fileManager.write(generatedName, resized, "png");
		System.out.println(result);
		return new ApiResponse();
	}
	
	
}
