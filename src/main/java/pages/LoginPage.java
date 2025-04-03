package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.AllureUtils;
import utils.ConfigReader;
import utils.WaitUtils;

public class LoginPage {
	private WebDriver driver;
	private WaitUtils wait;

	private By usernameField = By.id("user-name");
	private By passwordFiled = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.xpath("//div[@class='error-message-container error']/h3");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WaitUtils(driver, Duration.ofSeconds(30));

	}

	public InventoryPage login() {

		wait.waitForVisibility(driver.findElement(usernameField)).clear();
		driver.findElement(usernameField).sendKeys(ConfigReader.getProperty("username"));
		driver.findElement(passwordFiled).clear();
		driver.findElement(passwordFiled).sendKeys(ConfigReader.getProperty("password"));
		driver.findElement(loginButton).click();
		AllureUtils.captureScreenshot(driver);

		return new InventoryPage(driver);

	}

	public void invaidLogin(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordFiled).sendKeys(password);
		driver.findElement(loginButton).click();
		AllureUtils.captureScreenshot(driver);
	}

	public String errorMessage() {

		return driver.findElement(errorMessage).getText();
	}

}
