package com.gong.mapper;

import com.gong.entity.AnswerTxt;

import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: AnswerTxtDao
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/617:50
 **/
public interface AnswerTxtDao {
    public int create(AnswerTxt pi);
    public int delete(Map<String, Object> paramMap);
    public int update(Map<String, Object> paramMap);
    public List<AnswerTxt> query(Map<String, Object> paramMap);
    public AnswerTxt detail(Map<String, Object> paramMap);
    public int count(Map<String, Object> paramMap);
}
