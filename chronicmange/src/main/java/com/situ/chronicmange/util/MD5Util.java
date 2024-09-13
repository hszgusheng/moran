package com.situ.chronicmange.util;

import java.security.MessageDigest;
import java.util.Base64;

/*
* Md5工具类
* */
public class MD5Util {

    /**
     * MD5加密
     *
     * @param str 要加密的字符串
     * @return 加密后的字串
     */
    public static String getMD5(String str){
            String newStr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            newStr =  encodeBase64(md.digest(str.getBytes("utf-8")));
        } catch (Exception e) {

        }
        return newStr;
    }

    /**
     * Base64编码
     *
     * @param byteArray 要编码的字节数组
     * @return 编码后的字串
     */
    public static String encodeBase64(byte[] byteArray) {
        try {
            // 注: BASE64编码后的字串中，每超过76字节会产生一个换行符，因此需要替换删除掉。
            // RFC2045中规定: The encoded output stream must be represented in lines of
            // no more than 76 characters each.
            return Base64.getEncoder().encodeToString(byteArray).replaceAll("[\r\n]", "");
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123"));
    }
}
