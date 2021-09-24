package me.appz4.beacon.test.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.json.JSONObject;
import org.testng.Assert;

import me.appz4.beacon.model.api.ApiRequest;
import me.appz4.beacon.model.api.ApiRequestWithToken;
import me.appz4.beacon.model.api.ApiResponse;
import me.appz4.beacon.model.api.request.user.LoginRequest;
import me.appz4.beacon.model.api.response.user.LoginResponse;
import me.appz4.beacon.model.model.Token;
import me.appz4.beacon.test.util.JsonMapper;

public class ApiBaseTest {
	
	public static final String BASEURL = "http://localhost:8080/beacon-api/";
	
	public static final String CLIENTID = "Abc";
	
	private String baseUrl;
	
	private String clientId;
	
	private Client client;
	
	private Token token;
	
	public ApiBaseTest(String baseUrl, String clientId) {
		this.baseUrl = baseUrl;
		this.clientId = clientId;
	}
	
	private void createClient() {
		if(client == null) client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
	}
	
	protected <T> T post(String url, Object request, Class<T> responseClass) throws Exception {
		createClient();
		if(request instanceof ApiRequest) {
			((ApiRequest)request).setClientId(clientId);
		}
		if(request instanceof ApiRequestWithToken) {
			((ApiRequestWithToken)request).setToken(token.getToken());
		}
		String requestS = JsonMapper.toString(request);
		System.out.println(requestS);
		System.out.println(baseUrl+url);
		Response response = client.target(baseUrl+url)
			.request()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json;charset=UTF-8")
			.post(Entity.entity(request, MediaType.APPLICATION_JSON));
		String stringResponse = response.readEntity(String.class);
		debug(url, stringResponse);
		T ret = JsonMapper.toEntity(stringResponse, responseClass);
		return ret;
	}
	
	protected <T> T postMultiPart(String url, MultiPart multiPart, Class<T> responseClass) throws Exception {
		if(clientId != null) {
			multiPart.bodyPart(new FormDataBodyPart("clientId", clientId));
		}
		if(token != null) {
			multiPart.bodyPart(new FormDataBodyPart("token", token.getToken()));
		}
		Response response = client.target(baseUrl+url)
			.request()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json;charset=UTF-8")
			.post(Entity.entity(multiPart, multiPart.getMediaType()));
		String stringResponse = response.readEntity(String.class);
		debug(url, stringResponse);
		T ret = JsonMapper.toEntity(stringResponse, responseClass);
		return ret;
	}
	
	private void debug(String url, String response) {
		System.out.println("-------------------------"+url+"---------------------------------------");
		System.out.println(response);
		try {
			String prettyOutput = new JSONObject(response).toString(4);
			System.out.println(prettyOutput);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------------------------------------------");
	}
	
	protected void setToken(Token t) {
		this.token = t;
	}
	
	protected Token getToken() {
		return token;
	}
	
	protected String getClientId() {
		return clientId;
	}
	
	protected void addBodyPart(MultiPart multiPart, String name, String value) {
		 FormDataBodyPart part = new FormDataBodyPart(name, value);
		 multiPart.bodyPart(part);
	}
	
	protected void login(String email, String password) throws Exception {
		LoginRequest request = new LoginRequest();
		request.setEmail(email);
		request.setPassword(password);
		LoginResponse response = post("users/login", request, LoginResponse.class);
		Assert.assertEquals(response.isError(), false);
		Assert.assertNotNull(response.getUser());
		Assert.assertNotNull(response.getUser().getToken());
		setToken(response.getUser().getToken());
	}
	
	protected void hasError(ApiResponse response) {
		Assert.assertEquals(response.isError(), false);
	}
	
}
