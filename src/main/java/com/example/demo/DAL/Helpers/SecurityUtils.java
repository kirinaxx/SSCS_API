package com.example.demo.DAL.Helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*A utility class for security features such as password hashing*/
public class SecurityUtils {

    /**
     * Generates a SHA-512 hash for the given input string.
     *
     * @param input the input string to be hashed
     * @return the SHA-512 hash of the input string
     * @throws NoSuchAlgorithmException if the SHA-512 algorithm is not available
     */
    public static String generateHash(String input) throws NoSuchAlgorithmException {// Create a MessageDigest instance for SHA-512
        MessageDigest digest = MessageDigest.getInstance("SHA-512");

        // Compute the hash of the input string
        byte[] hashBytes = digest.digest(input.getBytes());

        // Convert byte array to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}