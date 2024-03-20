package org.redeyefrog.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptUtils {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encodeBCrypt(String str) {
        return encoder.encode(str);
    }

    public static boolean matchBCrypt(String str, String encodeStr) {
        return encoder.matches(str, encodeStr);
    }

}
