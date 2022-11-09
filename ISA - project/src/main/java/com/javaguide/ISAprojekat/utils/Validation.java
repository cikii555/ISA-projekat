package com.javaguide.ISAprojekat.utils;

public class Validation {
    private static final String REG_NAME = "^[a-zA-Z\\s]+";
    private static final String REG_EMAIL = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+$";
    private static final String REG_NUMBER = "^[0-9]+$";
    private static final String REG_PASSWORD = "^[a-zA-Z0-9!@#$%^&*()_+=]{6,30}$";
    private static final String REG_STREET = "^[a-zA-Z0-9 -.]+$";
    private static final String REG_WORDS = "^[a-zA-Z -]+$";

    public static boolean validateName(String name) {
        return name != null && name.matches(REG_NAME);
    }

    public static boolean validateEmail(String email) {
        return email != null && email.matches(REG_EMAIL);
    }

    public static boolean validateNumber(String toVal) {
        return toVal != null && toVal.matches(REG_NUMBER);
    }

    public static boolean validatePassword(String password) {
        return password != null && password.matches(REG_PASSWORD);
    }

    public static boolean validateWords(String words) {
        return words != null && words.matches(REG_WORDS);
    }

    public static boolean validateStreet(String street) {
        return street != null && street.matches(REG_STREET);
    }
}
