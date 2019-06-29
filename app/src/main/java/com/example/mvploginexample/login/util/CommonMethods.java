package com.example.mvploginexample.login.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sandeep on 25/11/16.
 */

public class CommonMethods {


    public static boolean isValidEmail(String email) {
        if (email == null || email.length() == 0) {
            return false;
        }
       /* String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";*/

        String EMAIL_PATTERN = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches())
            return true;
        else
            return false;
    }


    public static boolean isValidMobile(String mobile) {
        if (mobile != null || mobile.length() == 10) {

       /* String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";*/

            String EMAIL_PATTERN = "^[789]\\d{9}$";

            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(mobile);

            if (matcher.matches())
                return true;
            else
                return false;

        }
        return false;
    }





}
