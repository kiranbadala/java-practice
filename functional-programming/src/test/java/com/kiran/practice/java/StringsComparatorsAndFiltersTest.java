package com.kiran.practice.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class StringsComparatorsAndFiltersTest {

	@Test
	public void testStringIteration() {
		String str = "something";
		System.out.println("Printing chars in numbers.");
		str.chars().forEach(System.out::println);
		System.out.println("Printing chars ");
		str.chars().forEach(StringsComparatorsAndFiltersTest::printChars);
	}

	private static void printChars(int ch) {
		System.out.println((char) ch);
	}

	@Test
	public void testComapatorUsingLambdas() {
		final List<Person> people = Arrays.asList(new Person("John", 20), new Person("Sara", 21),
				new Person("Jane", 21), new Person("Greg", 35));
		System.out.println("Printing in age diff order .");
		people.stream().sorted(Person::ageDifference).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("Printing in name ascending order .");
		people.stream().sorted((pers1, pers2) -> {
			return pers1.getName().compareTo(pers2.getName());
		}).forEach(System.out::println);

		System.out.println("Printing in name descending order .");
		Comparator<Person> descPeopleComparator = (pers1, pers2) -> {
			return pers1.getName().compareTo(pers2.getName());
		};
		people.stream().sorted(descPeopleComparator.reversed()).forEach(System.out::println);
	}

	@Test
	public void testCollectorsClassAndCollectMethod() {
		final List<Person> people = Arrays.asList(new Person("John", 20), new Person("Sara", 21),
				new Person("Jane", 21), new Person("Greg", 35));
		System.out.println("Grouping the persons by age.");
		people.stream().collect(Collectors.groupingBy(Person::getAge)).forEach((key, value) -> {
			System.out.println("Key : " + key + " Value : " + value);
		});
		System.out.println("Group the persons by first chars and order the list by their name.");
		people.stream().sorted((p1, p2) -> {
			return p1.getName().compareTo(p2.getName());
		}).collect(Collectors.groupingBy((p) -> p.getName().charAt(0))).forEach((key, value) -> {
			System.out.println("Key : " + key + " Value : " + value);
		});
		System.out.println("Group the persons by first char and max age person name.");
		Comparator<Person> byAge = Comparator.comparing(Person::getAge);
		people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.reducing(BinaryOperator.maxBy(byAge))))
				.forEach((key, value) -> {
					System.out.println("Key : " + key + " Value : " + value);
				});
		;
	}
}