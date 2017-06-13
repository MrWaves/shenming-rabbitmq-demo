package com.lsm.springboot.task;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by za-lishenming on 2017/5/14.
 */
@Slf4j
public class ScheduledTest2 {

    public void executeFileDownLoadTask() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("quartz-定时任务1:"+current.getName());
        log.info("ScheduledTest.executeFileDownLoadTask quartz-定时任务1:"+current.getId()+ ",name:"+current.getName());
    }


}
