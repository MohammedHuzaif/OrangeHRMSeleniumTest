package utils.listeners;

import framework.BasePage;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonFunctions extends BasePage {
	private final Logger log = LogManager.getLogger(this.getClass());

	protected WebDriver driver;

	public CommonFunctions(WebDriver driver) {
		super(driver);
	}

	public void takeScreenshot() {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrnFile, new File(currentDir + "/screenshots" + formatTimeSDF() + ".png"));
		} catch (IOException e) {
			log.error("Exception in takeScreenshot method: " + e.getMessage());
		}
	}

	public void takeScreenshot(String testName) {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrnFile,
					new File(currentDir + "/screenshots/" + testName + "_" + formatTimeSDF() + ".png"));
		} catch (IOException e) {
			log.error("Exception in takeScreenshot method: " + e.getMessage());
		}
	}

	public static String formatTimeSDF() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
