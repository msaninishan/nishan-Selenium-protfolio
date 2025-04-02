package tests;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ExcelUtils;
@Listeners(utils.ScreenShotUtils.class)

public class CompletePuchrchaseTest extends BaseTest {
	
	@DataProvider(name = "checkoutDataFromExcel")
	public Object[][] getCheckoutData() throws IOException {
		String filePath = "src/test/resources/TestData.xlsx";
		return ExcelUtils.readExcelData(filePath, "CheckoutData");
	}

	@Test(dataProvider = "checkoutDataFromExcel")
	public void testCheckoutWithDifferentUsers(String firstName, String lastName, String zipCode) {
		loginPage.login();
		List<String> selectedProducts = Collections.singletonList("Sauce Labs Backpack");

		// Add product to cart
		for (String product : selectedProducts) {
			inventoryPage.addProductToCart(product);
		}
		inventoryPage.goToCart();
		cartPage.clickCheckout();
		checkoutPage.enterBillingDetails(firstName, lastName, zipCode);
		checkoutPage.completePurchase();

		Assert.assertTrue(checkoutPage.isOrderSuccessDisplayed(),
				"Order success message not displayed for " + firstName);
	}

}
