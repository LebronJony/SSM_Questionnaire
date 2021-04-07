package com.gong.mapper;

import com.gong.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: AdminMapper
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/422:37
 **/
public interface AdminDao {

    public int create(Admin pi);

    public int delete(Map<String,Object> paramMap);

    public int update(Map<String,Object> paramMap);

    public List<Admin> query(Map<String,Object> paramMap);

    public Admin detail(Map<String,Object> paramMap);

    public int count(Map<String,Object> paramMap);



}
