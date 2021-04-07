package com.gong.utils;

import org.springframework.util.DigestUtils;

/**
 * @author gonghongyu
 * @title: MD5Utils
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/1614:51
 **/
public class MD5Utils {

    //盐
    private static final String salt = "Survey###$$@@";

    public static String getMD5(String string){
        String val = string+salt;
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123456"));
    }
}