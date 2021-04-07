package com.gong.service;

import com.github.pagehelper.PageHelper;
import com.gong.entity.Question;
import com.gong.entity.QuestionOpt;
import com.gong.mapper.QuestionDao;
import com.gong.mapper.QuestionOptDao;
import com.gong.utils.BeanMapUtils;
import com.gong.utils.MapParameter;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gonghongyu
 * @title: QuestionService
 * @projectName question3
 * @description: TODO
 * @date 2021/2/520:45
 **/

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private QuestionOptDao questionOptDao;

    public int create(Question pi){
        int flag = 0;

        if (pi.getId() != null){
            flag = this.update(pi);
            questionOptDao.delete(MapParameter.getInstance().add("questionId",pi.getId()).getMap());
        } else {
            flag = questionDao.create(pi);
        }

        if (flag > 0){
            int i = 0;
            List<QuestionOpt> options = pi.getOptions();
            for (QuestionOpt option : options){
                option.setSurveyId(pi.getSurveyId());
                option.setQuestionId(pi.getId());
                option.setOrderby(++i);
                questionOptDao.create(option);
            }
        }
        return pi.getId();
    }

    public int delete(Integer id){

        return questionDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int deleteBatch(String ids){
        int flag = 0;
        List<String> list = Splitter.on(",").splitToList(ids);
        for (String s : list){
            questionDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            questionOptDao.delete(MapParameter.getInstance().add("questionId",Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int update(Question question){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(question)).addId(question.getId()).getMap();
        return questionDao.update(map);
    }


    public List<Question> query(Question question){
        //仅仅查询的问题
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(question)).getMap();
        List<Question> questionList = questionDao.query(map);
        List<QuestionOpt> optList = questionOptDao.query(MapParameter.getInstance().add("surveyId", question.getSurveyId()).getMap());
        for (Question question1 : questionList) {
            List<QuestionOpt> options = new ArrayList<>();
            for (QuestionOpt questionOpt : optList) {
                if(question1.getId() == questionOpt.getQuestionId()){
                    options.add(questionOpt);
                }
            }
            question1.setOptions(options);
        }
        return questionList;
    }


    public Question detail(Integer id){
        return questionDao.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Question question){
        Map<String,Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(question)).getMap();
        return questionDao.count(map);
    }



}
