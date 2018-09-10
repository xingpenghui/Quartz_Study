package com.feri.quartz;

import com.feri.job.MyJob1;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *@Author feri
 *@Date Created in 2018/9/10 10:08
 * 演示Qiartz的不同类型的触发器
 */
public class Quartz_Main2 {
    //简单触发器
    @Test
    public void test1() throws SchedulerException, InterruptedException {
        //执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //触发器
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("t1","g1").withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(3,2)).startNow().build();
        //作业
        JobDetail detail=JobBuilder.newJob(MyJob1.class).build();
        //设置
        scheduler.scheduleJob(detail,trigger);
        //启动
        scheduler.start();

        Thread.sleep(10000);
    }
    //日历触发器
    @Test
    public void test2() throws SchedulerException, InterruptedException {
        //执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //触发器
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("t1","g1").withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInSeconds(2)).startNow().build();
        //作业
        JobDetail detail=JobBuilder.newJob(MyJob1.class).build();
        //设置
        scheduler.scheduleJob(detail,trigger);
        //启动
        scheduler.start();

        Thread.sleep(10000);
    }
    //cron
    @Test
    public void test3() throws SchedulerException, InterruptedException {
        //执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //触发器
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("t1","g1").withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * ? * 1")).startNow().build();
        //作业
        JobDetail detail=JobBuilder.newJob(MyJob1.class).build();
        //设置
        scheduler.scheduleJob(detail,trigger);
        //启动
        scheduler.start();

        Thread.sleep(10000);
    }
}
