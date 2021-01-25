package com.six.map.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具
 *
 * @author zcl<yczclcn@163.com>
 */
public class MD5Utils {

    private static final String SALT = "1qazxsw2";

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 2;

    /**
     * 使用md5生成加密后的密码
     *
     * @param pswd
     * @return
     */
    public static String encrypt(String pswd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
        return newPassword;
    }

    public static String encryptFeiJing(String pswd) {
        return DigestUtils.md5DigestAsHex(pswd.getBytes());
    }

    /**
     * 使用md5生成加密后的密码
     *
     * @param username
     * @param pswd
     * @return
     */
    public static String encrypt(String username, String pswd) {
        return new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT), HASH_ITERATIONS).toHex();
    }

}
