package com.kiran.practice.guava_join_split_collections;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

public class GuavaMapsPractice {

	@SuppressWarnings("deprecation")
	@Test(expected=UnsupportedOperationException.class)
	public void testImmutaleMap() {
		ImmutableMap<String, String> imMap = ImmutableMap.<String,String>builder().put("a", "1").put("b", "2").put("c", "3").build();
		imMap.put("", "");
	}
	
	@Test
	public void testImmutableSortedMap() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ImmutableSortedMap<String, String> imMap =new  ImmutableSortedMap.Builder(Ordering.natural()).put("b", "2").put("a", "1").put("c", "3").build();
		System.out.println(imMap);
	}
	@Test
	public void testBiMap() {
	HashBiMap<String, String> biMap = HashBiMap.create();
	biMap.put("1", "a");
	biMap.put("2", "b");
	biMap.put("3", "c");
	biMap.put("4", "d");
	biMap.put("5", "e");
	System.out.println(biMap.get("1"));
	System.out.println(biMap.inverse().get("c"));
	}
	@Test
	public void testMultiMap() {
		ArrayListMultimap<Object, Object> multiMap = ArrayListMultimap.create();
		multiMap.put("a", "1");
		multiMap.put("b", "2");
		multiMap.put("c", "3");
		multiMap.put("a", "one");
		multiMap.put("d", "4");
		multiMap.put("b", "two");
		multiMap.put("e", "5");
		multiMap.put("d", "four");
		multiMap.put("f", "six");
		System.out.println(multiMap.get("f"));
		System.out.println(multiMap.get("b"));
		
	}
	@Test
	public void testGuavaTable() {
		HashBasedTable<String, String, Integer> table = HashBasedTable.create();
		table.put("Kiran", "Mamatha", 30);
		table.put("Nandu", "Aravind", 5);
		table.put("Karan", "Ravish", 25);
		table.put("Krishna", "Kruthup", 27);
		System.out.println(table.get("Krishna", "Kruthup"));
	}

}
