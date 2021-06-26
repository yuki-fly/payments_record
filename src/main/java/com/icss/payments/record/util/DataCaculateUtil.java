package com.icss.payments.record.util;

import java.math.BigDecimal;
import java.util.Map;

/**
 * caculate
 * 把数据切割，并把根据货币类型进行计算，最终结果存进到map
 * @author yuki
 *
 */
public class DataCaculateUtil {
	
	public static void Caculate(String line , Map<String,BigDecimal> datas){
		//1、空格切割，分开货币与金额
		//2、货币为key从map取值，与当前金额计算，并更新到map中
		 //split string in blank space
        String[] inputs = line.split(" ");
        if(inputs.length == 2){
        	String key = inputs[0];
        	try{
        		BigDecimal value = new BigDecimal(inputs[1]);
        		 //caculate new value
        		BigDecimal newValue = value.add( datas.containsKey(key) ? datas.get(key) : BigDecimal.ZERO );
        		 //not cache when newvalue is 0
        		 if(newValue.equals(BigDecimal.ZERO )  && datas.containsKey(key)){
        			 datas.remove(key);
        			 // datas1.remove(key);
     			}else{
     				datas.put(key, newValue);
     				//datas1.put(key, newValue);
     			}
        	}catch(Exception e){
        		System.out.println("error input with "+ line +",Please re-enter"  );
        	}
        }else{
        	System.out.println("error input with "+ line +",Please re-enter"  );
        }
	}

}
