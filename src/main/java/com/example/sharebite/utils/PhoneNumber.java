package com.example.sharebite.utils;

import java.util.regex.Pattern;

public class PhoneNumber {
    private static final String ph_regex = "^[7-9][0-9]{9}$";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(ph_regex, phoneNumber);
    }
}
