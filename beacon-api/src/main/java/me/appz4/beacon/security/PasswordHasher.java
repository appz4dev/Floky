package me.appz4.beacon.security;

public interface PasswordHasher {
	
	String hash(String password) throws Exception;
}
