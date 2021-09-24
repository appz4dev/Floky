package me.appz4.beacon.security;

import java.security.MessageDigest;

public class Sha512PasswordHasher implements PasswordHasher {

	@Override
	public String hash(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	return hexString.toString().toUpperCase();
	}

}
