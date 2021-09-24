package me.appz4.beacon.security;

import me.appz4.beacon.model.model.Client;

public class ClientContainer {
	
	private Client[] clients;
	
	public ClientContainer() {}
	
	public ClientContainer(Client... clients) {
		this.clients = clients;
	}
	
	public Client getClientByToken(String token) {
		for(Client i : clients) {
			if(i.getToken().equals(token)) {
				if(!i.getStatus().equals(1)) continue;
				return i;
			}
		}
		return null;
	}
	
}
