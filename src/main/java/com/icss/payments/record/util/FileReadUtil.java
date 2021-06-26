package com.icss.payments.record.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * file read util
 * 分行读取，并计算存进map中
 * @author yuki
 *
 */
public class FileReadUtil {
	public static void read(Map<String,BigDecimal> datas, String fileName){
		//分行读取数据
		//切割分开货币与金额，并把以货币为key,数值直接求和，存进map中
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {

            	DataCaculateUtil.Caculate(tempString, datas);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
        
}
