package com.feri.quartz;

import com.feri.job.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.quartz.spi.MutableTrigger;

import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2018/9/10 09:36
 * Quartz 初体验
 */
public class Quartz_Main1 {
    public static void main(String[] args) throws SchedulerException {

        //1、创建触发器
        Trigger trigger1=TriggerBuilder.newTrigger().withIdentity("trigger1","group1").withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3)).build();
        //2、创建定时的执行的内容
        JobDetail detail=JobBuilder.newJob(MyJob1.class).build();
        //3、创建执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //4、设置定时任务
        scheduler.scheduleJob(detail,trigger1);
        //5、执行
        scheduler.start();//启动
//        scheduler.resumeAll();//恢复
//        scheduler.pauseAll();//暂停
        //
        //scheduler.shutdown();//停止


    }
}
