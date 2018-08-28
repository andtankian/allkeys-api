package br.com.andrewribeiro.allkeys.utils;

import java.security.SecureRandom;

/**
 *
 * @author Andrew Ribeiro
 */
public class Utils {
    
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    public static String generateNewSecureCode(){
        final String numbers = "1234567890";
        final int length = 6;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(numbers.charAt(SECURE_RANDOM.nextInt(numbers.length())));
        }
        return sb.toString();
    }
    
    public static String cleanToValidBase64(String base64){
        String[] splittedBase64 = base64.split("base64,");
        String cleanBase64;
        
        if(splittedBase64 != null && splittedBase64.length > 1){
            cleanBase64 = splittedBase64[1];
        } else {
            cleanBase64 = splittedBase64[0];
        }
        
        return cleanBase64;
    }
    
}
