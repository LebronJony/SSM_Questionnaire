package com.gong.mapper;

import com.gong.entity.Question;

import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: QuestionDao
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/617:52
 **/
public interface QuestionDao {
    public int create(Question pi);
    public int delete(Map<String, Object> paramMap);
    public int update(Map<String, Object> paramMap);
    public List<Question> query(Map<String, Object> paramMap);
    public Question detail(Map<String, Object> paramMap);
    public int count(Map<String, Object> paramMap);
}
