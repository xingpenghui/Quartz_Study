package com.feri.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *@Author feri
 *@Date Created in 2018/9/10 11:25
 */
public class MyJob2 implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获取Map对象
      JobDataMap dataMap= context.getJobDetail().getJobDataMap();
        System.out.println(dataMap.get("name")+"-----来了");
    }
}
