package com.gong.mapper;

import com.gong.entity.QuestionOpt;

import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: QuestionOptDao
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/617:53
 **/
public interface QuestionOptDao {
    public int create(QuestionOpt pi);
    public int delete(Map<String, Object> paramMap);
    public int update(Map<String, Object> paramMap);
    public List<QuestionOpt> query(Map<String, Object> paramMap);
    public QuestionOpt detail(Map<String, Object> paramMap);
    public int count(Map<String, Object> paramMap);
}
