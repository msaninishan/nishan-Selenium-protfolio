package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	private WebDriver driver;
	private By cartItemNames = By.className("inventory_item_name");
	private By checkoutButton = By.id("checkout");
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getcartProducts() {
		List<WebElement> cartItem = driver.findElements(cartItemNames);

		return cartItem.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public void removeProductFromTheCart(String productName) {
		String removeButtonXpath = "//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button";
		driver.findElement(By.xpath(removeButtonXpath)).click();
	}

	public void clickCheckout() {
		driver.findElement(checkoutButton).click();
	}
}
