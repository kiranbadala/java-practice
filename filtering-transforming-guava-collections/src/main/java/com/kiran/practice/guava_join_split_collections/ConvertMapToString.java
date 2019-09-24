package com.kiran.practice.guava_join_split_collections;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Joiner;

public class ConvertMapToString {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d",4);
		//String newMap = Joiner.on(',').skipNulls().withKeyValueSeparator('-').join(map);
		String newMap = Joiner.on(',').withKeyValueSeparator('-').join(map);
		System.out.println(newMap);
	}
}
