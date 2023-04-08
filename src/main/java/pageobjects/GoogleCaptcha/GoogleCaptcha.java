package pageobjects.GoogleCaptcha;

import framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCaptcha extends BasePage {

    @FindBy(css=".recaptcha-checkbox-border")
    private WebElement captchaCheckBox;

    @FindBy(xpath = "//*[@title='reCAPTCHA']")
    private WebElement captchaFrame;

    public void clickReadCaptchaCheckBox() {
        driver.switchTo().frame(2);
        captchaCheckBox.click();
        driver.switchTo().defaultContent();
    }

    public GoogleCaptcha(WebDriver driver) {
        super(driver);
    }
}
