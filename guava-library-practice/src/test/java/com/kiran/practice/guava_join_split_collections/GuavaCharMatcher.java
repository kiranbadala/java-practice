package com.kiran.practice.guava_join_split_collections;

import org.junit.Test;

import com.google.common.base.CharMatcher;

public class GuavaCharMatcher {

	@Test
	public void testRemoveSpecialChars() {
		String str = "Hello!@#$123)(*&.,?/\"\':;[] {}\\|~!";
		CharMatcher charMat = CharMatcher.javaLetterOrDigit();
		System.out.println(charMat.retainFrom(str));
	}

	@Test
	public void testRemoveNonAsciChars() {
		String input = "あhello₤";
		CharMatcher charMatcher = CharMatcher.ascii();
		System.out.println(charMatcher.retainFrom(input));
	}

	@Test
	public void testValidateString() {
		String input = "hellowworld";
		System.out.println(CharMatcher.javaLowerCase().matchesAllOf(input));

	}

	@Test
	public void testCollapseString() {
		String input = " asnd-jdkwj-nckjw= kcjw ";
		System.out.println(CharMatcher.is(' ').collapseFrom(input, '-'));
		System.out.println(CharMatcher.is(' ').trimAndCollapseFrom(input, '-'));
	}

	@Test
	public void testReplaceString() {
		String str = "nwefwoc%nwjc@wk";
		System.out.println(CharMatcher.anyOf("@%").replaceFrom(str, '-'));
	}

	@Test
	public void testCountCharsInString() {
		String str = "dquiqwufkwehbvdjshgiowafhewo;azblvheil";
		System.out.println(CharMatcher.is(';').countIn(str));
	}

}
