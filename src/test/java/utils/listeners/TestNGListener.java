package utils.listeners;

import framework.BasePage;
import framework.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestNGListener extends BaseTest implements ITestListener  {

	private final Logger logger = LogManager.getLogger();

	@Override
	public void onStart(ITestContext iTestContext) {
		logger.info("I am in onStart method " + iTestContext.getName());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		logger.info("I am in onFinish method " + iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		logger.info("Test is starting: " + iTestResult.getName());
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		logger.info("Test is PASSED: " + iTestResult.getName());
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		logger.info("Test has failed: " + iTestResult.getName());

		try {
			Date currentDate = new Date();
			String screenshotFileName = currentDate.toString().replace("", "-").replace(":", "-");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));
			FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotFileName + ".png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		logger.info("Test skipped: " + iTestResult.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		logger.info("Test failed but it is in defined success ratio: " + iTestResult.getName());
	}
	public TestNGListener(WebDriver driver) {
		super(driver);
	}
}
