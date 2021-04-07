package com.gong.service;

import com.github.pagehelper.PageHelper;
import com.gong.entity.Admin;
import com.gong.mapper.AdminDao;
import com.gong.utils.BeanMapUtils;
import com.gong.utils.MapParameter;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: AdminService
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/520:45
 **/

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public int create(Admin pi){
        return adminDao.create(pi);
    }

    public int delete(Integer id){

        return adminDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int deleteBatch(String ids){
        int flag = 0;
        List<String> list = Splitter.on(",").splitToList(ids);
        for (String s : list){
            adminDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int update(Admin admin){
        Map<String,Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(admin)).addId(admin.getId()).getMap();
        return adminDao.update(map);
    }

    //通过使用mybatis的pagehelper来进行分页
    public List<Admin> query(Admin admin){
        PageHelper.startPage(admin.getPage(),admin.getLimit());
        Map<String,Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(admin)).getMap();
        return adminDao.query(map);
    }

    public Admin detail(Integer id){
        return adminDao.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Admin admin){
        Map<String,Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(admin)).getMap();
        return adminDao.count(map);
    }

    /**
     * 管理员登录
     * @param account
     * @param password
     * @return
     */
    public Admin login(String account,String password){
        Map<String, Object> map = MapParameter.getInstance().add("account",account).add("password",password).getMap();
        return adminDao.detail(map);
    }
}
