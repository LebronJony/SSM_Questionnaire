package com.gong.utils;

import com.gong.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author gonghongyu
 * @title: SessionUtils
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/1822:45
 **/
public class SessionUtils {
    private static final String key = "admin";

    public static void setAdmin(HttpServletRequest request, Admin admin){
        request.getSession().setAttribute(key,admin);
    }

    public static Admin getAdmin(HttpServletRequest request){
        if(request.getSession().getAttribute(key) != null){
            return (Admin) request.getSession().getAttribute(key);
        }else{
            return null;
        }
    }

}
