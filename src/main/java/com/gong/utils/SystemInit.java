package com.gong.utils;

import com.gong.entity.Admin;
import com.gong.mapper.AdminDao;
import com.gong.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: SystemStartInit
 * @projectName survey3
 * @description: 获得用户id对应的account
 * @date 2021/2/1913:22
 **/
public class SystemInit {

    @Autowired
    private AdminDao adminDao;

    //key为用户id value为用户对象Admin
    public static Map<Integer,Admin> adminMap = new HashMap<>();

    public void init(){

        //查询null为了获得所有admin数据
        List<Admin> list = adminDao.query(null);

        for (Admin admin : list){
            adminMap.put(admin.getId(), admin);
        }
    }
}
