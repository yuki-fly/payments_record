package com.icss.payments.record.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * console read util
 * 控制台数据读取，并计算存进map
 * @author yuki
 *
 */
public class ConsoleReadUtil {
	//public static Map<String,BigDecimal> datas = new HashMap<String,BigDecimal>();
	public static boolean read(Map<String,BigDecimal> datas){
		//实时读取控制台的输入流
		//一行一行读取，并把以货币为key,数值直接求和，存进map中
		//直到输入quite停止
		Scanner sc = new Scanner(System.in);
		 
        String input = "";
        //stop while input quit
        while (!"quit".equalsIgnoreCase(input = sc.nextLine())) {
        	DataCaculateUtil.Caculate(input, datas);
               
        }
        return true;
	}
	
	public static void main(String[] args){
		Map<String,BigDecimal> datas = new HashMap<String,BigDecimal>();
		read(datas);
	}

}
