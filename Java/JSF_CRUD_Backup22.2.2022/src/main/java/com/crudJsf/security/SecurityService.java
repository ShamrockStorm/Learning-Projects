package com.crudJsf.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class SecurityService {
	private static SecurityService instance;
	private SecurityService() {
		
	}
	
	public static SecurityService getInstance() {
		if(instance == null) {
			instance = new SecurityService();
		}
		return instance;
	}
	
	public static byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		int strength = 65536;
		
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, strength, 128);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		
		byte[] hash = factory.generateSecret(spec).getEncoded();
		return hash;
	}
	
	public static byte[] generateNewSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}
}
