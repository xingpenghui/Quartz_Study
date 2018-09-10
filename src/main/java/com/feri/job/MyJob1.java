package com.feri.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *@Author feri
 *@Date Created in 2018/9/10 09:47
 */
public class MyJob1 implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("重要的事情说三遍：进校区需要佩戴工牌，为了防止非法人士入侵！！！"+System.currentTimeMillis()/1000);
    }
}
