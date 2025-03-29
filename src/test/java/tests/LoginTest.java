package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {
		loginPage.login();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory"), "Login failed!");
	}

}
