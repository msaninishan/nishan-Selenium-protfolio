package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class AddToCartTest extends BaseTest {

	@Test
	public void verifyAddProductToCart() {
		loginPage.login();
		inventoryPage.addProductToCart("Sauce Labs Backpack").goToCart();
		List<String> getcartProducts = cartPage.getcartProducts();
		Assert.assertTrue(getcartProducts.contains("Sauce Labs Backpack"), "cart does not contain correct product. ");

	}

}
