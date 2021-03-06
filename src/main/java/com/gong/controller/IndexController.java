package com.gong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author gonghongyu
 * @title: IndexController
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/1617:03
 **/
@Controller
public class IndexController {

    @Value("classpath:init.json")
    private Resource resource;

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/menu")
    @ResponseBody
    public void menu(HttpServletResponse response) {
        try {
            File file = resource.getFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            StringBuffer sb = new StringBuffer();
            while ((str = bufferedReader.readLine()) !=null){
                sb.append(str);
            }
            bufferedReader.close();
            fileReader.close();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
