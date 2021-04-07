package com.gong.utils;

import com.gong.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



/**
 * @author gonghongyu
 * @title: ScheduleTask
 * @projectName survey3
 * @description: survey状态任务类
 * @date 2021/2/1917:45
 **/

@EnableScheduling
public class ScheduleTask {

    @Autowired
    private SurveyService surveyService;
    /**
     * 调查问卷状态的任务更新
     */
    @Scheduled(fixedRate = 20000)
    //@Scheduled(cron = "* */1 * * * ?")
    //@Scheduled(fixedRate = 20000)
    public void state(){
        surveyService.updateState();

    }
}
