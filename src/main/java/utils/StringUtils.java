package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: fujing
 * @Date: 2021/10/16
 * @Description:
 * @Version: 1.0
 */
public class StringUtils {
    public static void main(String[] args) {
        String a = "  ";
        String b = " hua ";
        System.out.println(isNullOrEmpty(a));//true
        System.out.println(isNullOrEmpty(b));//false
    }


    /**
     * MD5加密
     *
     * @param str
     * @return 32位的加密字符串
     */
    public static String getMD5str(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            md5.update(str.getBytes());
            byte[] digest = md5.digest();

            return byte2Hex(digest);

        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    private static String byte2Hex(byte[] digest) {

        return null;
    }


    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

}
