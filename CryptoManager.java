/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 21/10/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Robel Endahsaw
*/








/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		/*
		  Create a for loop that checks if each character in plainText is with in range
		  if the character is out of bound return false else return true;
		  
		 */
		for(int i=0;i<plainText.length();++i) {
			if(!(plainText.charAt(i)>=LOWER_RANGE && plainText.charAt(i)<=UPPER_RANGE) ) {
				return false;
			}
			
			
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
       /*
        * Declear 
        */
       
		String encrypted = "";
		for(int i=0;i<plainText.length();++i) {
			if(!(plainText.charAt(i)>=LOWER_RANGE && plainText.charAt(i)<=UPPER_RANGE) ) {
				return "The selected string is not in bounds, Try again.";
			}
			
			
		}

		for (int i=0; i<plainText.length(); i++){
				
			int encryptedChar = (plainText.charAt(i)+key);
				
			while (encryptedChar > UPPER_RANGE){
				encryptedChar -= RANGE;
				}
				encrypted += (char)encryptedChar;
				}
		
		
		return encrypted;

		
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		
		String encrypted="";
		if(bellasoStr.length()<plainText.length()) {
			for(int i=bellasoStr.length(), j=0;i<plainText.length();++i,++j) {
				bellasoStr+= bellasoStr.charAt(j);
			}
		}
		
		for(int i=0;i<plainText.length();++i) {
			int char_value = (plainText.charAt(i)+ bellasoStr.charAt(i));
			while(char_value>UPPER_RANGE) {
				char_value-=RANGE;
			}
			encrypted+= (char) char_value;
		}
		
	
		
		return encrypted;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String Decrypted="";
		for(int i=0;i<encryptedText.length();++i) {
			int Decrypted_char=encryptedText.charAt(i)-key;
			while(Decrypted_char<LOWER_RANGE) {
				Decrypted_char+=RANGE;
			}
			Decrypted+= (char)Decrypted_char;
		}
		return Decrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decrypted="";
		
		for(int i=0;i<encryptedText.length();++i) {
			int char_value= encryptedText.charAt(i)-bellasoStr.charAt(i%bellasoStr.length());
			while(char_value<LOWER_RANGE) {
				char_value+=RANGE;
			}
			
			decrypted+=(char) char_value;
		}
		
		return decrypted;
	}
}
