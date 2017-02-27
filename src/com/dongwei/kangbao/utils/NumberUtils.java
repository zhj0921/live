package com.dongwei.kangbao.utils;

import java.math.BigDecimal;

public class NumberUtils {

	public static String formatFloatNumber(Double value) {
        if(value != null){
            if(value.doubleValue() != 0.00){
            	
            	BigDecimal bg = new BigDecimal(value);  
            	value= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
            	String value1 = String.valueOf(value);
            	return value1;
            }else{
                return "0.0";
            }
        }
        return "0.0";
    }
	
	public static Double formatFloatNumber1(Double value) {
		if(value != null){
			if(value.doubleValue() != 0.00){
				
				BigDecimal bg = new BigDecimal(value);  
				value= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
				
				return value;
			}else{
				return 0.0;
			}
		}
		return 0.0;
	}
	
}
