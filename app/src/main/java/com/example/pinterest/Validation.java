package com.example.pinterest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_REGEX= "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+" ;

    private Pattern pattern=Pattern.compile(EMAIL_REGEX);

    public boolean validationEmail(String email){

        Matcher matcher =pattern.matcher(email);
        return matcher.matches();
    }

}
