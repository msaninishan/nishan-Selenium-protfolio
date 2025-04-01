package utils;

import java.io.ByteArrayInputStream;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class RetryAnalyzer implements IRetryAnalyzer {

	private static final int maxRetryCount = Integer.parseInt(ConfigReader.getProperty("retryCount"));
	private int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			String message = "Retrying test: " + result.getName() + " | Attempt: " + (retryCount + 1);
			Allure.addAttachment("Retry Info", new ByteArrayInputStream(message.getBytes()));
			return true; // Retry the test
		}
		return false; // Stop retrying
	}
}
