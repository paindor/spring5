package com.hanrabong.web.lambda;

import java.util.HashMap;
import java.util.Map;

public class LambdaMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.forEach((k,v)->System.out.println(String.format("{%s , %s}", k,v)));
		
		

	}

}
