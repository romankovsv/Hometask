package utils;

import java.util.Random;


public class Generator {

    public static String getEmail(){
        return generateOnlyLowerCaseLettersWithLength(6) + "." + genRandomStringWithLength(6) + "@ukr.net";
    }

    public static String getPassword(){
        return generateOnlyUpperLettersWithLength(4)+generateOnlyLowerCaseLettersWithLength(4)+ getRandomNumberWithLength(2)+ generateSymbolsWithLength(3);
    }

    public static String getZipCode(){
        return getRandomNumberWithLength(5);
    }

    public static String generateOnlyUpperLettersWithLength(int length){
        String alphabet =
                new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        String result = new String();
        Random r = new Random();
        int n = alphabet.length();

        for (int i = 0; i < length; i++)
            result = result + alphabet.charAt(r.nextInt(n));

        return result;
    }

    public static String generateOnlyLowerCaseLettersWithLength(int length){
        String alphabet =
                new String("abcdefghijklmnopqrstuvwxyz");

        String result = new String();
        Random r = new Random();
        int n = alphabet.length();

        for (int i = 0; i < length; i++)
            result = result + alphabet.charAt(r.nextInt(n));

        return result;
    }

    public static String generateSymbolsWithLength(int length){
        String alphabet =
                new String("!@#$%?");

        String result = new String();
        Random r = new Random();
        int n = alphabet.length();

        for (int i = 0; i < length; i++)
            result = result + alphabet.charAt(r.nextInt(n));

        return result;
    }

    public static String genRandomStringWithLength(int count) {


        String alphabet =
                new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        int n = alphabet.length();

        String result = new String();
        Random r = new Random();

        for (int i = 0; i < count; i++)
            result = result + alphabet.charAt(r.nextInt(n));

        return result;
    }

    public static String getRandomNumberWithLength(int length){
        Random random = new Random();

        StringBuffer res = new StringBuffer();
        int result;
        for (int i = 0; i < length; i++) {
            result = (random.nextInt(9 - 1 + 1) + 1);
            res.append(String.valueOf(result));
        }

        return res.toString();
    }
}
