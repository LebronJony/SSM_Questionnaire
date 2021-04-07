package com.gong.controller;

import com.gong.entity.Admin;
import com.gong.service.AdminService;
import com.gong.utils.MD5Utils;
import com.gong.utils.MapControl;
import com.gong.utils.SessionUtils;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: LoginController
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/1322:03
 **/

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String v_login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String,Object> map, HttpServletRequest request){
        String account = map.get("account") + "";
        String password = map.get("password") + "";
        if (Strings.isNullOrEmpty(account) || Strings.isNullOrEmpty(password)){
            return MapControl.getInstance().error("用户名或密码不能为空").getMap();
        }

        Admin admin = adminService.login(account, MD5Utils.getMD5(password));

        if (admin != null) {
            SessionUtils.setAdmin(request,admin);
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error("用户名或密码错误").getMap();
        }
    }
}
