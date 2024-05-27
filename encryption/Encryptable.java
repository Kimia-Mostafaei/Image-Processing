
/*
* This interface defines methods for encryption.
* Student Name:Kimia Mostafaei
* Student Number:041078848
* Course: CST8132 Object Oriented Programming
* Program: CET-CS-Level 2
* Professor: Fred
*
*/
package encryption;
/**
 * This interface defines methods for encryption.
 * @author cakim
 *
 */
public interface Encryptable {
	
	public static final int START_CHAR = ' ';
	public static final int END_CHAR = 'z';
	public static final int RANGE = END_CHAR-START_CHAR+1;
	/**
	 * this method is for encrypting
	 * @param input
	 * @return encryptedText
	 */
	public String encrypt(String input);
	/**
	 * this method is for decrypting
	 * @param input
	 * @return decryptedText
	 */
	public String decrypt(String input);	
}
