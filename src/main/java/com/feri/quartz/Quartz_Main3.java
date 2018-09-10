package com.feri.quartz;

import com.feri.job.MyJob1;
import com.feri.job.MyJob2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *@Author feri
 *@Date Created in 2018/9/10 11:24
 */
public class Quartz_Main3 {
    public static void main(String[] args) throws Exception{
        //1、创建触发器
        Trigger trigger1=TriggerBuilder.newTrigger().withIdentity("trigger1","group1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * 11 * * ?")).build();
        //2、创建定时的执行的内容
        JobDetail detail=JobBuilder.newJob(MyJob2.class).build();
        JobDataMap dataMap=detail.getJobDataMap();
        dataMap.put("name","张三");
        //3、创建执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //4、设置定时任务
        scheduler.scheduleJob(detail,trigger1);
        //5、执行
        scheduler.start();//启动
    }
}
