package com.kiran.practice.guava_join_split_collections;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class GuavaCollectionsFilteringTransformingTest {

	@Test
	public void testGuavaFilterACollection() {
		List<String> list = Lists.newArrayList("kiran", "karan", "krishna", "krutup", "karunakar");
		Iterable<String> result = Iterables.filter(list, Predicates.containsPattern("i"));
		System.out.println(result);
	}

	@Test
	public void testCollection2Filter() {
		Predicate<String> predicate = new Predicate<String>() {
			public boolean apply(String input) {
				return input.contains("u");
			}
		};
		List<String> list = Lists.newArrayList("kiran", "karan", "krishna", "krutup", "karunakar");
		System.out.println(Collections2.filter(list, predicate));
	}

	@Test
	public void testFilterWithMulitplePreciates() {
		List<String> list = Lists.newArrayList("kiran", "karan", "krishna", "krutup", "karunakar", null);
		System.out.println(Collections2.filter(list,
				Predicates.or(Predicates.containsPattern("u"), Predicates.not(Predicates.containsPattern("k")))));
	}

	@Test
	public void testFilterPredicatesWithoutNull() {
		List<String> list = Lists.newArrayList("kiran", "karan", "krishna", "krutup", "karunakar", null);
		System.out.println(Collections2.filter(list, Predicates.notNull()));
	}

	@Test
	public void testCollectionMatchCondintion() {
		List<String> list = Lists.newArrayList("kiran", "karan", "krishna", "krutup", "karunakar");
		System.out.println(Iterables.contains(list, "kiran"));
	}

	@Test
	public void testIterablesTransform() {
		Function<String, String> function = new Function<String, String>() {
			public String apply(String input) {
				return new StringBuilder(input).reverse().toString();
			}
		};
		List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
		Iterable<String> result = Iterables.transform(names, function);
		System.out.println(result);
	}
	@Test
	public void testCollections2FunctionsFromPredicate() {
		List<String> list = Lists.newArrayList("kiran", "karan", "krishna", "krutup", "karunakar");
		System.out.println(Collections2.transform(list, Functions.forPredicate(Predicates.containsPattern("u"))));
	}
	@Test
	public void testFiltersCombineWithTransformation() {
		List<String> list = Lists.newArrayList("kiran", "karan", "krishna", "krutup", "karunakar");
		Predicate<String> pred = new Predicate<String>() {
			
			public boolean apply(String input) {
				return input.contains("ra");
			}
		};
		Function<String,Integer> func = new Function<String, Integer>() {
			
			public Integer apply(String input) {
				return input.length();
			}
		};
		System.out.println(FluentIterable.from(list).filter(pred).transform(func).toList());
	}
}
