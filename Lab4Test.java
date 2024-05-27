/*
 * Main class for generating menu items for user and let user choose an option for encryption
 * Student Name:Kimia Mostafaei
 * Student Number:041078848
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Fred
 *
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import encryption.Encryptable;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

public class Lab4Test {


	private Scanner input = new Scanner (System.in);

	/**
	 * using a varag of menu options have user select one and return option number 
	 * @param options
	 * @return userOption
	 */

	public int getMenuItem(String... options) {

		int userOption;

		do {
			System.out.println("Select action:");

			for (int i = 0; i < options.length; i++) {
				System.out.println("     "+(i+1)+"-"+options[i]);
			}

			try {
				userOption = input.nextInt();
				input.nextLine(); 
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				input.nextLine(); 
				userOption = -1;
			}
		} while (userOption < 1 || userOption > options.length);

		return userOption;
	}

	/**
	 * get a string from the user
	 * @param prompt is for getting string 
	 * @return userInput 
	 */

	public String getString(String prompt) {
		System.out.println(prompt);		
		String userInput= input.nextLine().trim();
		return userInput;
	}
	/**
	 * get an integer from the user
	 * @param prompt is for getting string
	 * @param min is for getting the minimum of the range
	 * @param max is for getting the maximum of the range
	 * @return userInputInt 
	 */

	public int getInt(String prompt, int min, int max) {

		int userInputInt;
		boolean repeat;

		do {
			System.out.println(prompt);

			try {
				userInputInt = input.nextInt();
				repeat = userInputInt < min || userInputInt > max;
				input.nextLine(); 
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				input.nextLine(); 
				repeat = true;
				userInputInt = -1;
			}
		} while (repeat);

		return userInputInt;

	}

	/**
	 * this method is for getting the encryption method  from the user
	 * @return choosenMethod
	 */
	private Encryptable getMethod() {

		int caesarShift = 0;

		Encryptable chosenMethod = null;

		int method=getMenuItem("Caesar Cipher", "Vigenere Cipher");
		switch(method) {
		case 1:
			int caesarShift1 = getInt("Shift value:", 0, Encryptable.RANGE);
			chosenMethod = new CaesarCipher(caesarShift1);
			break;
		case 2:
			String vigenerePassword = getString("Password:");
			chosenMethod = new VigenereCipher(vigenerePassword);
			break;

		}
		return chosenMethod;
	}

	/**
	 * Application main
	 * @param args
	 */
	public static void main(String args[]) {


		ArrayList<String> encryptedText=new ArrayList<String>();
		Lab4Test test = new Lab4Test();
		int choice;
		String text;
		System.out.println("Encryption tester");

		do {
			choice=test.getMenuItem("Encrypt text", "Decrypt text","Display encrypted list","exit");

			switch (choice) {
			case 1:
				text=test.getString("Please enter text to be encrypted: ");
				Encryptable encryptMethod=test.getMethod();
				String encryptText=encryptMethod.encrypt(text);
				encryptedText.add(encryptText);
				System.out.println("Encrypted Value is "+ encryptText);
				break;

			case 2:
				if(encryptedText.isEmpty()) {
					System.out.println("nothing to decrypt");
				}else {
					int encryptList = test.getInt("Message number you want to decrypt : ", 1, encryptedText.size());
					Encryptable decryptMethod=test.getMethod();
					String decryptText=decryptMethod.decrypt(encryptedText.get(encryptList-1));
					System.out.println("Dncrypted Value is #"+ encryptList + " "+ decryptText);
				}
				break;
			case 3:
				if(encryptedText.isEmpty()) {
					System.out.println("nothing to display");
				}else {
					System.out.println("-------");
					for (int i=0;i<encryptedText.size();i++) {
						System.out.println("#"+ (i+1)+ ": "+encryptedText.get(i));
					}
					System.out.println("------");
				}
				break;
			case 4:
				break;		
			}
		}while(choice !=4);
		System.out.println("Good bye!");

	}

}
