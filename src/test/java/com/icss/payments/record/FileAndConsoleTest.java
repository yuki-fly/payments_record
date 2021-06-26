package com.icss.payments.record;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.icss.payments.record.util.ConsoleReadUtil;
import com.icss.payments.record.util.FileReadUtil;
import com.icss.payments.record.util.QuartzUtil;

public class FileAndConsoleTest {

	@Test
	public void test() {
		Map<String,BigDecimal> datas = new HashMap<String,BigDecimal>();
		//print
		Scheduler scheduler = QuartzUtil.startQuartz("param" , datas);
		//file read
		FileReadUtil.read(datas, System.getProperty("user.dir") + File.separator + "file" + File.separator + "test.txt");
		//read fro consle
		boolean b = ConsoleReadUtil.read(datas);
		
		if(b){
			try {
				scheduler.shutdown();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}

}
