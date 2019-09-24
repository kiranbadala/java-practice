package com.kiran.practice.guava_join_split_collections;

import com.google.common.base.Splitter;

public class CreateListFromString {
	public static void main(String[] args) {
		String str = "a-b-c-d-e-r-t------";
		System.out.println(Splitter.on('-').splitToList(str));
		String mapStr = "a-b,c-d,e-r,t-d";
		System.out.println(Splitter.on(',').withKeyValueSeparator('-').split(mapStr));
		String lenStr = "1,2,4,5,6,7,8";
		System.out.println(Splitter.fixedLength(2).limit(2).splitToList(lenStr));
	}
}