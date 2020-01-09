package com.kiran.practice.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class UsingCollectionsTest {

	@DisplayName("Iterating and Transforming elements using java 8 features.")
	@Test
	public void testIterateThroughList() {
		final List<String> friends = new ArrayList<>();
		IntStream.range(1, 100000).forEach(num -> {
			friends.add("frind" + num);
		});
		System.out.println("Executing with forEach loop :- ");
		ElapsedTimeCalculator.executeAndCalculateTime((str) -> {
			for (String temp : friends) {
				String upperStr = temp.toUpperCase();
				if (upperStr.contains("5")) {

				}
			}
		});

		System.out.println("\nExecuting with stream api   :- ");
		ElapsedTimeCalculator.executeAndCalculateTime((str) -> {
			friends.stream().map(String::toUpperCase).filter((friend) -> {
				return friend.contains("5");
			}).collect(Collectors.toList());
		});

		System.out.println("\nExecuting with parelal stream api   :- ");
		ElapsedTimeCalculator.executeAndCalculateTime((str) -> {
			friends.parallelStream().map(String::toUpperCase).filter((friend) -> {
				return friend.contains("5");
			}).collect(Collectors.toList());
		});

	}

	@Test
	public void testFindingElements() {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		System.out
				.println("Result : " + friends.stream().filter((el) -> el.contains("a")).collect(Collectors.toList()));
	}

	@Test
	public void testReUsingLambdaExpressions() {
		System.out.println("Executing testReUsingLambdaExpressions.");
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Kiran", "Nate", "Neal", "KAran", "Aravind", "Scott");
		final List<String> students = Arrays.asList("Nandu", "MAdhu", "Neal", "Raju", "Rohith", "Scott");
		Predicate<String> stringContainsN = (string) -> string.contains("N");
		ElapsedTimeCalculator.executeAndCalculateTime((str) -> {
			System.out.println("Result : " + friends.stream().filter(stringContainsN).collect(Collectors.toList()));
		});
		System.out.println(
				"Result for editors : " + editors.stream().filter(stringContainsN).collect(Collectors.toList()));
		System.out.println(
				"Result for students : " + students.stream().filter(stringContainsN).collect(Collectors.toList()));
	}

	@Test
	public void testGenericLmbdaExpressionsForFilter() {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Kiran", "Nate", "Neal", "KAran", "Aravind", "Scott");
		final List<String> students = Arrays.asList("Nandu", "MAdhu", "Neal", "Raju", "Rohith", "Scott");

		Function<String, Predicate<String>> charCheckFunction = (checkCahr) -> {
			return (name) -> {
				return name.contains(checkCahr);
			};
		};
		System.out.println("Result for 'a' in friends : "
				+ friends.stream().filter(charCheckFunction.apply("a")).collect(Collectors.toList()));
		System.out.println("Result for 'n' in editors : "
				+ editors.stream().filter(charCheckFunction.apply("n")).collect(Collectors.toList()));
		System.out.println("Result for 't' in students : "
				+ students.stream().filter(charCheckFunction.apply("t")).collect(Collectors.toList()));
	}

	@Test
	public void testPickingAnElement() {
		Function<String, Predicate<String>> charCheckFunction = (checkCahr) -> {
			return (name) -> {
				return name.startsWith(checkCahr);
			};
		};
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		Optional<String> result = friends.stream().filter(charCheckFunction.apply("S")).findFirst();
		result.ifPresent(System.out::println);
	}

	@Test
	public void testReducingCollectionToOneElement() {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		System.out.println("Result : " + friends.stream().reduce((name1, name2) -> {
			return name1.length() > name2.length() ? name1 : name2;
		}).get());
		System.out.println("Sum of all chars in list of strings : " + friends.stream().mapToInt(String::length).sum());
	}

	@Test
	public void testJoiningFunctionality() {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		System.out.println("Joining by using string.join method : " + String.join(",", friends));

		System.out
				.println("Joining using streams and collector : " + friends.stream().collect(Collectors.joining(",")));
	}

}
