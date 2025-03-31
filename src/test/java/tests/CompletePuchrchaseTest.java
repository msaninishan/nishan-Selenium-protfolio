package tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CompletePuchrchaseTest extends BaseTest {

	@Test
	public void testCompletePurchase() {
		loginPage.login();
		List<String> selectedProducts = Collections.singletonList("Sauce Labs Backpack");

		// Add product to cart
		for (String product : selectedProducts) {
			inventoryPage.addProductToCart(product);
		}
		inventoryPage.goToCart();
		cartPage.clickCheckout();
		checkoutPage.enterBillingDetails("nasu", "esu", "12345");
		checkoutPage.completePurchase();

		Assert.assertTrue(checkoutPage.isOrderSuccessDisplayed(), "order success message is not displayed");
	}

}
