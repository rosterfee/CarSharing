package ru.itis.javalab.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordHasher {

    public static String getHashPassword(String password) {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        byte[] bytes = md5.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b: bytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

}
