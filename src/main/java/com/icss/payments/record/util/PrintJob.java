package com.icss.payments.record.util;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 打印结果的job
 * @author yuki
 *
 */
public class PrintJob implements Job {

	@Override
	public void execute(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("start print------");
		 JobDataMap data = paramJobExecutionContext.getJobDetail().getJobDataMap();
		Map<String , BigDecimal> datas = (Map<String, BigDecimal>) data.get("param");
		for(Entry<String , BigDecimal> entry : datas.entrySet()){
        	System.out.println(entry.getKey() + "-----" + entry.getValue().toString());
        }
		
		System.out.println("end print----");
	}

}
