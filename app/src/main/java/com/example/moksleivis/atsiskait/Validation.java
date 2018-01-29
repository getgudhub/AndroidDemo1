package com.example.moksleivis.atsiskait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by moksleivis on 2018-01-29.
 */

public class Validation {

    private static final String VALID_CREDENTIALS_REGEX ="^[A-Za-z0-9]{3,20}$";
    private static final String VALID_EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isValidCredentials(String credentials){
        Pattern credentialsPattern = Pattern.compile(VALID_CREDENTIALS_REGEX);
        Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
        return credentialsMatcher.find();
    }

    public static boolean isValidEmail(String credentials){
        Pattern credentialsPattern = Pattern.compile(VALID_EMAIL_REGEX);
        Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
        return credentialsMatcher.find();
    }
}
