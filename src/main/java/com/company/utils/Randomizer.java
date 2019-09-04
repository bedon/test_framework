package com.company.utils;

public class Randomizer {

    private static String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

    public static String generateRandomMail(int stringSize) {
        String randomString;
        StringBuilder sb = new StringBuilder(stringSize);

        for (int i = 0; i < stringSize; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        randomString = sb.toString();
        return randomString + "@mail.ru";
    }

    public static void main(String[] args) {
        System.out.println(Randomizer.generateRandomMail(5));
    }
}
