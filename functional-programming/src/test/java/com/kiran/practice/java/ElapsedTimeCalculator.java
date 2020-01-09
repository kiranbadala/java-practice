package com.kiran.practice.java;

import java.util.function.Consumer;

public class ElapsedTimeCalculator {

	private static long currentTime = 0l;

	public static void executeAndCalculateTime(Consumer<String> consumer) {
		currentTime = System.currentTimeMillis();
		consumer.accept("");
		System.out.println("\nTime taken for the execution : "+(System.currentTimeMillis()-currentTime));
	}

}
