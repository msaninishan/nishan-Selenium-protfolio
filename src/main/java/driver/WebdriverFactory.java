package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class WebdriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			String browser = ConfigReader.getProperty("browser");
			boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

			WebDriver newDriver;
			switch (browser.toLowerCase()) {
			case "chrome":
				ChromeOptions coption = new ChromeOptions();
				if (headless) {
					coption.addArguments("--headless");
				}
				newDriver = new ChromeDriver(coption);
				break;
			case "firefox":
				newDriver = new FirefoxDriver();
				break;
			case "edge":
				newDriver = new EdgeDriver();
				break;
			default:
				throw new RuntimeException("Unsupported browser: " + browser);
			}

			newDriver.manage().window().maximize();
			newDriver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicit.wait"))));
			driver.set(newDriver);
		}
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
