package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
	private WebDriver driver;

	private By inventory_List = By.className("inventory_list");
	private By productSortContainer = By.className("product_sort_container");
	private By inventory_item_name = By.className("inventory_item_name");
	private By inventory_item_price = By.className("inventory_item_price");
	public InventoryPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement InventoryList() {

		return driver.findElement(inventory_List);

	}

	public void selectSortingOption(String optionText) {
		WebElement dropdown = driver.findElement(productSortContainer);
		Select select = new Select(dropdown);
		select.selectByVisibleText(optionText);
	}

	public List<String> getProductNames() {
		return driver.findElements(inventory_item_name).stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<Double> getProductPrices() {
		return driver.findElements(inventory_item_price).stream()
				.map(element -> Double.parseDouble(element.getText().replace("$", ""))).collect(Collectors.toList());
	}

}
