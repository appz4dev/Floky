package me.appz4.beacon.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class HttpServiceImpl implements HttpService {
	
	private Client client;
	
	public HttpServiceImpl() {
		createClient();
	}
	
	protected void createClient() {
		client = ClientBuilder.newBuilder().build();
	}
	
}
