
/*
 *
 * Student Name:Kimia Mostafaei
 * Student Number:041078848
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Fred
 *
 */
package encryption.ciphers;

import encryption.Encryptable;

public class VigenereCipher implements Encryptable{
	private String key;
	private int keyLength;

	public VigenereCipher(String password ){

		key=password;
		keyLength=password.length();
	}
	/**
	 * method that gives the encrypted version of the given string using a Vigenere cipher 
	 */
	@Override  
	public String encrypt(String input) {

		char result[]=new char [input.length()];
		int keyIndex=0;
		for(int i =0;i<input.length();i++) {

			if(keyIndex==keyLength) {
				keyIndex=0;
			} 
			char letter= input.charAt(i);
			char letterKey=key.charAt(keyIndex);
			result[i]=(char)(((letter-START_CHAR)+(letterKey-START_CHAR))%RANGE+START_CHAR);
			
			/*if(encrypted>=RANGE) {
				encrypted-=RANGE;
			}

			encrypted+=START_CHAR;
			 */
			
			//result[i]=(char)encrypted;
			//System.out.println((int)result[i]);
			keyIndex++; 
		}
		return new String (result);
	}
	/**
	 * method that gives the decrypted version of the given encrypted string using a Vigenere cipher 
	 */
	@Override  
	public String decrypt(String input) {

		char resultt[]=new char [input.length()];
		int keyIndex=0;
		for(int i =0;i<input.length();i++) {
			if(keyIndex==keyLength) {
				keyIndex=0;
			}
			char letter= input.charAt(i);

			char letterKey=key.charAt(keyIndex);
			resultt[i]=(char)((letter-letterKey+RANGE)%RANGE+START_CHAR);
			keyIndex++; 
		}
		return new String (resultt);
		
	}


}
