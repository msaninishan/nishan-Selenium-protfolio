package base;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.WebdriverFactory;
import io.qameta.allure.Allure;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

public class BaseTest {
	public static WebDriver driver;
	public LoginPage loginPage;
	public InventoryPage inventoryPage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = WebdriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		driver.get(ConfigReader.getProperty("base.url"));
	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Allure.addAttachment("Failed Test Screenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}

		WebdriverFactory.quitDriver();

	}
}
