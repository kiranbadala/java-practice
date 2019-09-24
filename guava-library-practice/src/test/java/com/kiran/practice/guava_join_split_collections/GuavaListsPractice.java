package com.kiran.practice.guava_join_split_collections;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class GuavaListsPractice {

	@Test
	public void testListReverse() {
		List<String> list = Lists.newArrayList("a","c","b","d"); 
		assertEquals(Lists.newArrayList("d","b","c","a"), Lists.reverse(list));
	}

	@Test
	public void testListPartitioning() {
		List<String> list = Lists.newArrayList("a","c","b","d","f","e","h","g","k","i","l"); 
		System.out.println(Lists.partition(list, 2));
		assertEquals(6, Lists.partition(list, 2).size());
	}
	@Test
	public void testListDuplicateRemoval() {
		List<String> list = Lists.newArrayList("a","c","b","d","a","e","h","g","b","i","l"); 
		System.out.println(ImmutableSet.copyOf(list).asList());
		assertEquals(9,ImmutableSet.copyOf(list).asList().size() );
	}
	@Test
	public void testListNullRemoval() {
		List<String> list = Lists.newArrayList("a","c","b","d","a","e","h",null,"b","i",null); 
		Iterables.removeIf(list, Predicates.isNull());
		assertEquals(9,list.size());
	}
	@Test(expected=UnsupportedOperationException.class)
	public void testListAsImmutableList() {
		List<String> list = Lists.newArrayList("a","c","b","d","a","e","h","b","i"); 
	list = ImmutableList.copyOf(list);
	list.add("asd");
	}
	

}
