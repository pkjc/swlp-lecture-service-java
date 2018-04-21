package com.swlp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		 ArrayList<Map<String, String>> mpList = new ArrayList<>();
		
		 Map<String, String> mp = new HashMap<>();
		
		{
			mp.put("0", "0");
			mpList.add(mp);
			mp.put("1", "1");
			mpList.add(mp);
			mp.put("2", "2");
			mpList.add(mp);
		}
		
		System.out.println(mpList.get(0).get("0"));
//		System.out.println(mpList.get(1));
//		System.out.println(mpList.get(2));

	}

}
