package com.kiran.practice.guava_join_split_collections;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;

public class GuavaCacheTest {

	@Test
	public void testCacheSimple() throws ExecutionException {
		CacheLoader<String, String> loader = new CacheLoader<String, String>() {

			@Override
			public String load(String key) throws Exception {
				return key.toUpperCase();
			}

		};
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(loader);
		cache.getUnchecked("KIRAN");
		cache.getUnchecked("KARAN");
		cache.getUnchecked("KuRAN");
		cache.getUnchecked("KARAN");
		System.out.println(cache.size());
		cache.getUnchecked("KIRAN");
		System.out.println(cache.size());
		System.out.println(cache.getUnchecked("kiran"));
	}

	@Test
	public void testGuavaCacheMaxSize() throws ExecutionException {
		CacheLoader<String, String> loader = new CacheLoader<String, String>() {

			@Override
			public String load(String key) throws Exception {
				return key.toUpperCase();
			}

		};
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).build(loader);
		cache.getUnchecked("KIRAN");
		cache.getUnchecked("KARAN");
		cache.getUnchecked("KuRAN");
		cache.getUnchecked("KRAN");
		System.out.println(cache.size());
		System.out.println();
	}

	@Test
	public void testGuavaCacheMaxWeight() throws ExecutionException {
		CacheLoader<String, String> loader = new CacheLoader<String, String>() {

			@Override
			public String load(String key) throws Exception {
				return key.toUpperCase();
			}

		};
		Weigher<String, String> weigher = new Weigher<String, String>() {
			public int weigh(String key, String value) {
				return key.length();
			}
		};
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumWeight(10).weigher(weigher).build(loader);
		cache.getUnchecked("KIRAN");
		cache.getUnchecked("KARAN");
		cache.getUnchecked("KuRAN");
		cache.getUnchecked("KRAN");
		System.out.println(cache.size());
		System.out.println();
	}
	@Test
	public void testGuavaCacheMaxTime() throws ExecutionException {
		CacheLoader<String, String> loader = new CacheLoader<String, String>() {

			@Override
			public String load(String key) throws Exception {
				return key.toUpperCase();
			}

		};
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(loader);
		cache.getUnchecked("KIRAN");
		cache.getUnchecked("KARAN");
		cache.getUnchecked("KuRAN");
		cache.getUnchecked("KRAN");
		System.out.println(cache.size());
		System.out.println();
	}

}
