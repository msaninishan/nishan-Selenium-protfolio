package tests;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;



public class ProductSortTest extends BaseTest {

	@Test(priority = 0)
	public void Verify_the_product_list_is_displayed_after_login() {

		Assert.assertTrue(loginPage.login().InventoryList().isDisplayed(), "product List is not displayed");

	}

	@Test(priority = 1)
	public void testSortByNameAscending() {
		loginPage.login();
		inventoryPage.selectSortingOption("Name (A to Z)");
		List<String> productNames = inventoryPage.getProductNames();
		List<String> sortedNames = productNames.stream().sorted().collect(Collectors.toList());

		Assert.assertEquals(productNames, sortedNames, "product are not sorted in ascending order");
	}

	@Test(priority = 2)
	public void testSortByNameDescending() {
		loginPage.login();
		inventoryPage.selectSortingOption("Name (Z to A)");
		List<String> productNames = inventoryPage.getProductNames();
		List<String> sortedNames = productNames.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

		Assert.assertEquals(productNames, sortedNames, "product are not sorted in descending order");
	}

	@Test(priority = 3, invocationCount = 1)
	public void testSortByPriceLowToHigh() {
		loginPage.login();
		inventoryPage.selectSortingOption("Price (low to high)");
		List<Double> productPrices = inventoryPage.getProductPrices();
		List<Double> sortedPrices = productPrices.stream().sorted().collect(Collectors.toList());
		Assert.fail("failed");
		Assert.assertEquals(productPrices, sortedPrices, "Products are not sorted by price (Low to High)!");
	}

	@Test(priority = 4)
	public void testSortByPriceHighToLow() {
		loginPage.login();
		inventoryPage.selectSortingOption("Price (high to low)");
		List<Double> productPrices = inventoryPage.getProductPrices();
		List<Double> sortedPrices = productPrices.stream().sorted((a, b) -> Double.compare(b, a))
				.collect(Collectors.toList());

		Assert.assertEquals(productPrices, sortedPrices, "Products are not sorted by price (High to Low)!");
	}
}
