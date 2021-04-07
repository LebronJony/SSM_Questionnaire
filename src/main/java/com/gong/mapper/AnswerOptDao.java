package com.gong.mapper;

import com.gong.entity.AnswerOpt;

import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: AnswerOptDao
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/617:48
 **/
public interface AnswerOptDao {
    public int create(AnswerOpt pi);
    public int delete(Map<String, Object> paramMap);
    public int update(Map<String, Object> paramMap);
    public List<AnswerOpt> query(Map<String, Object> paramMap);
    public AnswerOpt detail(Map<String, Object> paramMap);
    public int count(Map<String, Object> paramMap);
}
