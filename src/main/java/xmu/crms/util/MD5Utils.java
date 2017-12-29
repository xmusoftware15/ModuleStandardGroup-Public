package xmu.crms.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * @author Internet
 * @modified LiuXuezhang
 */
public class MD5Utils {
    public static String MD5encode(String str) {
        try{
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            String newStr=base64en.encode(md5.digest(str.getBytes("utf-8")));
            return newStr;
        }catch (Exception e){
            return null;
        }

    }
}
