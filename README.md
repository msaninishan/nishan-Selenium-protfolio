**Project Overview**

This is a Selenium-based test automation framework designed for UI testing of a web application. It follows the Page Object Model (POM) pattern and integrates with TestNG for test execution and Allure for reporting.

**Project Structure**

**1. src/main/java (Main Framework Code)**

**Base Package (base)**

BaseTest.java - Manages the setup and teardown of WebDriver instances.

**Driver Package (driver)**

WebdriverFactory.java - Responsible for initializing WebDriver instances based on configuration.

**Pages Package (pages)**

CartPage.java - Represents the cart page of the application.

CheckoutPage.java - Represents the checkout page.

InventoryPage.java - Represents the inventory or product listing page.

LoginPage.java - Handles login page interactions.

**Utils Package (utils)**

AllureUtils.java - Manages Allure reporting integration.

ConfigReader.java - Reads configurations from config.properties.

ExcelUtils.java - Handles reading and writing Excel data.

RetryAnalyzer.java - Implements retry logic for flaky tests.

RetryListener.java - Listens to test failures and applies retries.

ScreenShotUtils.java - Captures screenshots for reporting purposes.

**WaitUtils.java - Manages explicit waits for element interactions.**

2. **src/test/java (Test Cases)**

**Tests Package (tests)**

AddToCartTest.java - Tests adding items to the cart.

CompletePurchaseTest.java - Tests completing a purchase.

LoginTest.java - Tests login functionality.

LoginTest1.java - Additional login tests.

ProductSortTest.java - Tests sorting functionality on the inventory page.

RemoveProductTest.java - Tests removing products from the cart.

3. **src/test/resources (Test Data & Configurations)**

allure.properties - Configuration for Allure reporting.

config.properties - Stores environment configurations.

TestData.xlsx - Contains test data for parameterized tests.

4. **report/allure-results (Test Reports)**

**Contains Allure-generated test execution results.**

5. **target/test-output (Generated TestNG Reports)
**
AllTesttestng.xml - Consolidated test report.

CompletePurchaseTesttestng.xml - Specific report for purchase test.

product.xml - Another test execution configuration.

testng.xml - Main TestNG suite configuration.

6. **pom.xml (Maven Configuration)**

Defines project dependencies, plugins, and test execution configurations.

**Technologies Used**

Selenium WebDriver - Browser automation

TestNG - Test execution and assertions

Allure Reports - Test reporting

Maven - Build automation

Excel - Data-driven testing support

Java 21 - Programming language

**How to Execute Tests**

Clone the Repository:

git clone <repository_url>
cd selenium-automation

Configure Test Data & Properties:

Modify config.properties to set up environment variables.

**Run Tests Using Maven:**

mvn clean test

**Generate Allure Report:**

mvn allure:serve

