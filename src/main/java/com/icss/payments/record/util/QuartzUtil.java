package com.icss.payments.record.util;

import java.util.HashMap;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
/**
 * 定时任务
 * @author yuki
 *
 */
public class QuartzUtil {
	public static Scheduler startQuartz(String JOB_PARAM_KEY , Map paramMap){
		Scheduler scheduler = null;
        try {
        	// First we must get a reference to a scheduler
            SchedulerFactory sf = new StdSchedulerFactory();
            scheduler = sf.getScheduler();
        	
        	//构建job信息
            JobDetail jobDetail = JobBuilder.newJob(PrintJob.class).withIdentity(JobKey.jobKey("Task_1")).build();

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 * * * * ? *")
            		.withMisfireHandlingInstructionDoNothing();
            		
            	   
            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(TriggerKey.triggerKey("Task_1")).withSchedule(scheduleBuilder).build();

            //放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(JOB_PARAM_KEY, paramMap);

            scheduler.scheduleJob(jobDetail, trigger);
            
            scheduler.start();
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
		return scheduler;
	}
	public static void main(String[] args) {
		String JOB_PARAM_KEY = "param";
		Map<String , String> aa = new HashMap<String , String>();
		aa.put("time" , "11");
        try {
        	// First we must get a reference to a scheduler
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
        	
        	//构建job信息
            JobDetail jobDetail = JobBuilder.newJob(PrintJob.class).withIdentity(JobKey.jobKey("Task_1")).build();

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 * * * * ? *")
            		.withMisfireHandlingInstructionDoNothing();
            		
            	   /* CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/20 * * * * ?"))
            	            .build();
*/
            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(TriggerKey.triggerKey("Task_1")).withSchedule(scheduleBuilder).build();

            //放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(JOB_PARAM_KEY, aa);

            scheduler.scheduleJob(jobDetail, trigger);
            
            scheduler.start();
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
