package com.gong.controller;

import com.gong.entity.Admin;
import com.gong.service.AdminService;
import com.gong.utils.MD5Utils;
import com.gong.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: AdminController
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/521:05
 **/

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/create")
    public String v_create(){
        return "admin/add";
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String ,Object> create(@RequestBody Admin admin){
        admin.setPassword(MD5Utils.getMD5(admin.getPassword()));
        int result = adminService.create(admin);
        if (result <= 0){
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String ,Object> delete(String ids){
        int result = adminService.deleteBatch(ids);

        if (result <= 0){
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String ,Object> update(@RequestBody Admin admin){
        int result = adminService.update(admin);
        if (result <= 0){
            return MapControl.getInstance().error().getMap();
        }
        return MapControl.getInstance().success().getMap();
    }


    @GetMapping("/list")
    public String list(){
        return "admin/list";
    }

    //通过ModelMap将controller数据传递给JSP页面
    @PostMapping("/query")
    @ResponseBody
    public Map<String,Object> query(@RequestBody Admin admin, ModelMap modelMap){
        List<Admin> list = adminService.query(admin);
        Integer count = adminService.count(admin);
        return MapControl.getInstance().page(list,count).getMap();
    }


    @GetMapping("/detail")
    public String detail(Integer id,ModelMap modelMap){
        Admin admin = adminService.detail(id);
        modelMap.addAttribute("admin",admin);
        return "admin/update";
    }
}
