package com.gong.entity;

import com.gong.utils.Entity;

import java.util.Date;

/**
 * @author gonghongyu
 * @title: Admin
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/1822:02
 **/
public class Admin extends Entity {

    /**
     *
     */
    private String account;
    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String password;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private String remark;

    private Date now;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}