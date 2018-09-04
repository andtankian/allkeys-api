package br.com.andrewribeiro.allkeys.utils;

import br.com.andrewribeiro.ribrest.model.interfaces.Model;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Base64;

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
    
    public static String saveFileAndGenerateLink(String possibleBase64) throws IOException {        
        String base64 = cleanToValidBase64(possibleBase64);
        byte[] dataBase64 = Base64.getDecoder().decode(base64);
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = stringBuilder.append(System.currentTimeMillis()).append(".png").toString();
        stringBuilder.delete(0, stringBuilder.length());
        Path path = Paths.get(stringBuilder.append(Constants.STATIC_SRC).append(File.separator).append(fileName).toString());
        Files.write(path,dataBase64);
        stringBuilder.delete(0, stringBuilder.length());        
        return stringBuilder.append(Constants.BASE_URL)
                .append(Constants.STATIC_PATH)
                .append(File.separator)
                .append(fileName).toString();
    }
}
