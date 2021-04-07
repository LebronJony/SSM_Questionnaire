package com.gong.service;

import com.github.pagehelper.PageHelper;
import com.gong.entity.AnswerOpt;
import com.gong.entity.AnswerTxt;
import com.gong.entity.Survey;
import com.gong.mapper.AnswerOptDao;
import com.gong.mapper.AnswerTxtDao;
import com.gong.mapper.SurveyDao;
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
 * @title: SurveyService
 * @projectName survey3
 * @description: TODO
 * @date 2021/2/520:45
 **/

@Service
@Transactional
public class SurveyService {


    @Autowired
    private AnswerTxtDao answerTxtDao;

    @Autowired
    private AnswerOptDao answerOptDao;

    @Autowired
    private SurveyDao surveyDao;

    public int create(Survey pi){
        return surveyDao.create(pi);
    }

    public int delete(Integer id){

        return surveyDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int deleteBatch(String ids){
        int flag = 0;
        List<String> list = Splitter.on(",").splitToList(ids);
        for (String s : list){
            surveyDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int update(Survey survey){
        Map<String,Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(survey)).addId(survey.getId()).getMap();
        return surveyDao.update(map);
    }

    //通过使用mybatis的pagehelper来进行分页
    public List<Survey> query(Survey survey){
        PageHelper.startPage(survey.getPage(),survey.getLimit());
        Map<String,Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyDao.query(map);
    }

    public List<Survey> queryAll(Survey survey){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyDao.query(map);
    }

    public List<AnswerOpt> queryAnswerOpt(AnswerOpt answerOpt){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(answerOpt)).getMap();
        return answerOptDao.query(map);
    }

    public Survey detail(Integer id){
        return surveyDao.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Survey survey){
        Map<String,Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyDao.count(map);
    }

    public void updateState(){
        //查询出来，更新状态
        List<Integer> list = surveyDao.queryByState(Survey.state_create);
        for (Integer id : list) {
            surveyDao.update(MapParameter.getInstance().add("updateState",Survey.state_exec).add("id",id).getMap());
        }
        List<Integer> list2 = surveyDao.queryByStateForExec(Survey.state_exec);
        for (Integer id : list2) {
            surveyDao.update(MapParameter.getInstance().add("updateState",Survey.state_over).add("id",id).getMap());
        }
    }

    public Integer submit(List<AnswerOpt> opts, List<AnswerTxt> txts){
        int flag = 0;
        for (AnswerOpt opt : opts) {
            flag = answerOptDao.create(opt);
        }
        for (AnswerTxt txt : txts) {
            flag = answerTxtDao.create(txt);
        }
        return flag;
    }

}
