package com.shc.blog.test;

import org.junit.Test;

public class TestIp {

	@Test
	public void decodeUnicode() { 
		String utfStr = "\u5e7f\u5dde\u5e02";
		System.out.println(utfStr);
        final StringBuffer buffer = new StringBuffer(); 
        String charStr = ""; 
        String operStr = utfStr; 
        for(int i =0 ; i < utfStr.length() ;i=+4){ 
            charStr = operStr.substring(0, 4); 
            operStr = operStr.substring(4, operStr.length());
            System.out.println(operStr);
            char letter = (char) Integer.parseInt(charStr, 16);
            buffer.append(new Character(letter).toString()); 
        } 
        System.out.println(buffer);
    }
	
	@Test
    public void convert(){  
		String utfString = "\u5e7f\u5dde\u5e02";
        StringBuilder sb = new StringBuilder();  
        int i = -1;  
        int pos = 0;  
          
        while((i=utfString.indexOf("\\u", pos)) != -1){  
            sb.append(utfString.substring(pos, i));  
            if(i+5 < utfString.length()){  
                pos = i+6;  
                sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));  
            }  
        }  
          
        System.out.println(sb.toString());  
    }  
}
