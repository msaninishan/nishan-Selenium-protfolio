package tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {
		loginPage.login();
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("inventory"), "Login failed!");
	}

	@Test
	public void tesInvalidLogin() {
		loginPage.invaidLogin("user", "suer");

		AssertJUnit.assertEquals(loginPage.errorMessage(),
				"Epic sadface: Username and password do not match any user in this service");
	}

}
