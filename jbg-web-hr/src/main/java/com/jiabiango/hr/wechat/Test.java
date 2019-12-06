package com.jiabiango.hr.wechat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Test {  
  
	public static void main(String[] args) {
		/*Map<String,String> map = new HashMap<String,String>();  
        map.put("apple", "新鲜的苹果"); // 向列表中添加数据  
        map.put("computer", "配置优良的计算机"); // 向列表中添加数据  
        map.put("book", "堆积成山的图书"); // 向列表中添加数据  
        String key = "book";  
        boolean contains = map.containsKey(key);  
        if (contains) {  
            System.out.println("在Map集合中包含键名" + key);  
        } else {  
            System.out.println("在Map集合中不包含键名" + key);  
        }  */
		String start = "08:00:00";
		String end = "18:00:00";
		Date now = new Date();
		int hours = now.getHours();
		int minutes = now.getMinutes();
		String[] startList = start.split(":");
		System.out.println(startList.length +"时："+startList[0]+"分："+startList[1]);
		System.out.println("时："+hours+"分："+minutes);
	}
}  