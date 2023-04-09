package pageobjects.CookieBar;

import framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieBarPage extends BasePage {
    @FindBy(css = ".accept-cookie-container")
    private WebElement acceptCookiesButton;

    public void clickAcceptCookiesButton(){
        acceptCookiesButton.click();
    }

    public CookieBarPage(WebDriver driver) {
        super(driver);
    }
}
