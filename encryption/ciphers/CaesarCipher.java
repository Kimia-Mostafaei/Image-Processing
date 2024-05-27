
/*
 * A brief description of the role of this class
 * Student Name:Kimia Mostafaei
 * Student Number:041078848
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Fred
 *
 */
package encryption.ciphers;
import encryption.Encryptable;

public class CaesarCipher implements Encryptable {

	private int key;
	/**
	 * create Caesar cipher with the given shift 
	 * @param shift
	 */

	public CaesarCipher(int shift){
		key=shift;

	}


	/**
	 * method that gives the encrypted version of the given string using a Caesar cipher 
	 */
	@Override 

	public String encrypt(String input) {

		char result[]=new char [input.length()];
		for(int i =0;i<input.length();i++) {
			char letter= input.charAt(i);
			if(letter >=START_CHAR && letter <=END_CHAR ) {
				result[i] =(char)((letter-START_CHAR + key)%RANGE +START_CHAR);	
			}
		}
		return new String (result);
	}

	/**
	 * method that gives the decrypted version of the given encrypted string using a Caesar cipher 
	 */
	@Override  
	public String decrypt(String input) {

		char result[]=new char [input.length()];
		for(int i =0;i<input.length();i++) {

			char letter= input.charAt(i);
			if(letter >=START_CHAR && letter <=END_CHAR ) {
				result[i] =(char)((letter-START_CHAR - key + RANGE)%RANGE +START_CHAR);	
			}
		}
		return new String (result);
	}
}
