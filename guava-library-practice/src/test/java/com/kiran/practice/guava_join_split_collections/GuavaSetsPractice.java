package com.kiran.practice.guava_join_split_collections;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeRangeSet;

public class GuavaSetsPractice {

	@Test
	public void testSetsUnionSet() {
		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		Set<String> set2 = Sets.newHashSet("a", "d", "e");
		Set<String> unionSet = Sets.union(set1, set2);
		assertEquals(unionSet, Sets.newHashSet("a", "b", "c", "d", "e"));
	}

	@Test
	public void testSetsIntersectionSet() {
		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		Set<String> set2 = Sets.newHashSet("a", "d", "e");
		Set<String> intersectionSet = Sets.intersection(set1, set2);
		assertEquals(intersectionSet, Sets.newHashSet("a"));
	}

	@Test
	public void testSetsSymmetricalDifferenceSet() {
		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		Set<String> set2 = Sets.newHashSet("b", "c", "e");
		Set<String> intersectionSet = Sets.symmetricDifference(set1, set2);
		assertEquals(intersectionSet, Sets.newHashSet("a", "e"));
	}

	@Test
	public void testSetsCartesianProductSet() {
		Set<String> set1 = Sets.newHashSet("a", "b");
		Set<String> set2 = Sets.newHashSet("d", "c");
		Set<List<String>> cartesianProduct = Sets.cartesianProduct(ImmutableList.of(set1, set2));
		System.out.println(cartesianProduct);
	}

	@Test
	public void testSetsPowerSet() {
		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		Set<Set<String>> powerSet = Sets.powerSet(set1);
		System.out.println(powerSet.toString());
	}

	@Test
	public void testContigiuosSet() {
		ContiguousSet.create(Range.closed(1, 10), DiscreteDomain.integers()).stream().forEach((el)->{System.out.println(el);});
	}
	@Test
	public void testRangeSet() {
		RangeSet<Integer> rangeSet = TreeRangeSet.create();
		rangeSet.add(Range.closed(1, 9));
		rangeSet.add(Range.closed(12, 20));
		System.out.println(rangeSet.span());
		rangeSet.add(Range.closed(10, 11));
		System.out.println(rangeSet.asRanges());
		System.out.println(rangeSet.complement());
	}
	@Test
	public void testMultiSet() {
		Multiset<String> multiSet = HashMultiset.create();
		multiSet.add("a");
		multiSet.add("b");
		multiSet.add("c");
		multiSet.add("a");
		multiSet.add("d",5);
		multiSet.add("a");
		multiSet.add("c");
		multiSet.add("c");
		System.out.println(multiSet.count("d"));
		System.out.println(multiSet);
		System.out.println(Multisets.copyHighestCountFirst(multiSet).elementSet());
		
	}

}
