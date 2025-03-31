package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class RemoveProductTest extends BaseTest {

	@Test
	public void testRemoveProductFromCart() {

		loginPage.login();

		List<String> selectedProducts = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

		// Add products to the cart
		for (String product : selectedProducts) {
			inventoryPage.addProductToCart(product);
		}

		inventoryPage.goToCart();

		// Verify products are added
		List<String> cartProductsBeforeRemoval = cartPage.getcartProducts();
		Assert.assertEquals(cartProductsBeforeRemoval, selectedProducts,
				"Cart does not contain correct products before removal.");

		// Remove one product
		String productToRemove = "Sauce Labs Backpack";
		cartPage.removeProductFromTheCart(productToRemove);

		// Verify product is removed
		List<String> cartProductsAfterRemoval = cartPage.getcartProducts();
		Assert.assertFalse(cartProductsAfterRemoval.contains(productToRemove),
				"The product was not removed from the cart.");
	}

}
