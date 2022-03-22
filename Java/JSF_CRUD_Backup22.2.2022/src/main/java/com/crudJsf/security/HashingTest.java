package com.crudJsf.security;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashingTest {
	
	public static byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		int strength = 65536;
		
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, strength, 128);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		
		byte[] hash = factory.generateSecret(spec).getEncoded();
		return hash;
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String password = cin.next();
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		byte[] hash = null;
		
		try {
			hash = hashPassword(password, salt);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String saltString = new String(salt);
		//String hashString = new String(hash);
		
		String saltString = new String(salt, StandardCharsets. ISO_8859_1);
		String hashString = new String(hash, StandardCharsets. ISO_8859_1);
		
		//byte[] saltBack = saltString.getBytes();
		byte[] saltBack = saltString.getBytes(StandardCharsets.ISO_8859_1);
		String saltBackString = new String(saltBack, StandardCharsets. ISO_8859_1);
		
		System.out.println(saltString);
		System.out.println(saltBackString);
		System.out.println(hashString);
		
		int i=0;
		while(!Arrays.equals(salt, saltBack) && i<=20) {
			System.out.println("Salt recovery failed");
			//saltBack = saltString.getBytes();
			saltBack = saltString.getBytes(StandardCharsets.ISO_8859_1);
			i++;
		}
		
		if(Arrays.equals(salt, saltBack))System.out.println("Salt brought back succesfully");
		else System.out.println("Salt recovery failed");
		
		 
	}

}
