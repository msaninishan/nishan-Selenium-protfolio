package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.AllureUtils;

public class CheckoutPage {
	private WebDriver driver;

	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By zipCodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By finishButton = By.id("finish");
	private By successMessage = By.xpath("//h2[contains(text(),'Thank you for your order!')]");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterBillingDetails(String firstName, String lastName, String zipCode) {
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(zipCodeField).sendKeys(zipCode);
		driver.findElement(continueButton).click();
		AllureUtils.captureScreenshot(driver);
	}

	public void completePurchase() {
		driver.findElement(finishButton).click();
		AllureUtils.captureScreenshot(driver);
	}

	public boolean isOrderSuccessDisplayed() {
		return driver.findElement(successMessage).isDisplayed();
	}

}
