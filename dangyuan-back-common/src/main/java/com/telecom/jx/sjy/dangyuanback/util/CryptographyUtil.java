package com.telecom.jx.sjy.dangyuanback.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;

public class CryptographyUtil {

    /**
     * base64加密
     *
     * @param str
     * @return
     */
    public static String encBase64(String str) {
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * base64解密
     *
     * @param str
     * @return
     */
    public static String decBase64(String str) {
        return Base64.decodeToString(str);
    }

    /**
     * Md5加密
     *
     * @param source
     * @param salt
     * @param hashIterations
     * @return
     */
    public static String md5(String source, String salt, int hashIterations) {
        return new SimpleHash("MD5", source, salt, hashIterations).toString();
    }

    public static void main(String[] args) {
        String password = "Ad123@min";
        String password2 = "123456";
        System.out.println("Base64加密" + CryptographyUtil.encBase64(password));
        System.out.println("Base64解密" + CryptographyUtil.decBase64(CryptographyUtil.encBase64(password)));

        System.out.println("Md5加密" + CryptographyUtil.md5(password2, "dangyuan", 2));


    }
}
