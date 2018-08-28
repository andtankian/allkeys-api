package br.com.andrewribeiro.allkeys.user.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java email validation program
 *
 * @author pankaj
 *
 */
public class EmailValidator {

    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static Pattern pattern;
    private Matcher matcher;

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    
    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
