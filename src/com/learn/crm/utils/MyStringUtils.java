package com.learn.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MyStringUtils {
    /**
     *
     * @param value plaintext
     * @return cipherText
     */
    public static String getMD5Value(String value){
        try {
            //1.get utils tool
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //2.cipherText
            byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
            //3.decimal => hexadecimal
            BigInteger bigInteger = new BigInteger(1,md5ValueByteArray);


            return bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getMD5Value("1234"));
    }
}
