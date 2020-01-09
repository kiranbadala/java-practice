package com.kiran.practice.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class DesigningWithLambdasTest {

	@Test
	public void testSeparateDesignConcernsFromMethods() {
		final List<Asset> assets = Arrays.asList(new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.BOND, 2000), new Asset(Asset.AssetType.STOCK, 3000),
				new Asset(Asset.AssetType.STOCK, 4000));
		System.out.println("Total asset value :" + totalAssetValues(assets));

		System.out.println("Total asset value of stocks :"
				+ totalAssetValues(assets, (asset) -> asset.getType().equals(Asset.AssetType.STOCK)));

		System.out.println("Total asset value of stocks without refactoring:" + totalAssetValuesForStocks(assets));

		System.out.println("Total asset value of bonds without refactoring:" + totalAssetValuesForBonds(assets));

		System.out.println("Total asset value of bonds with refactoring :"
				+ totalAssetValues(assets, (asset) -> asset.getType().equals(Asset.AssetType.BOND)));
	}

	// Without refactoring the method with three(Way of Iterating,What to Sum and
	// How to sum) concerns.
	private static int totalAssetValues(List<Asset> assets) {
		return assets.stream().mapToInt(Asset::getValue).sum();
	}

	// Without refactoring the method with three(Way of Iterating,What to Sum and
	// How to sum) concerns.
	private static int totalAssetValuesForStocks(List<Asset> assets) {
		return assets.stream().filter((asset) -> asset.getType().equals(Asset.AssetType.STOCK))
				.mapToInt(Asset::getValue).sum();
	}

	// Without refactoring the method with three(Way of Iterating,What to Sum and
	// How to sum) concerns.
	private static int totalAssetValuesForBonds(List<Asset> assets) {
		return assets.stream().filter((asset) -> asset.getType().equals(Asset.AssetType.BOND)).mapToInt(Asset::getValue)
				.sum();
	}

	// Refactored method with what to sum concerns separated.
	private static int totalAssetValues(List<Asset> assets, Predicate<Asset> predicate) {
		return assets.stream().filter(predicate).mapToInt(Asset::getValue).sum();
	}

	@Test
	public void testDelegatingClassConcernsWithLambdas() {
		CalculateNAV calc = new CalculateNAV((stock) -> {
			return new BigDecimal(100);
		});
		System.out.println("Stock value for google : " + calc.computeStockWorth("GOOG", 10));
	}
	
	@Test
	public void testCreateFluentInterfaces() {

	}
}