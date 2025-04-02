package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import driver.WebdriverFactory;

public class ScreenShotUtils implements ITestListener {

	// Attach screenshot directly into Allure report


	@Override
	public void onTestStart(ITestResult result) {
		AllureUtils.captureScreenshot(WebdriverFactory.getDriver());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		AllureUtils.captureScreenshot(WebdriverFactory.getDriver());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		AllureUtils.captureScreenshot(WebdriverFactory.getDriver());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		AllureUtils.captureScreenshot(WebdriverFactory.getDriver());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		AllureUtils.captureScreenshot(WebdriverFactory.getDriver());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		AllureUtils.captureScreenshot(WebdriverFactory.getDriver());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
