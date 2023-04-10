package orangeHRM.pageobjects.CookieBar;

import framework.BasePage;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

public class CookieBarPage extends BasePage {
    @FindBy(css = ".accept-cookie-container")
    private WebElement acceptCookiesButton;

    @SneakyThrows
    public void clickAcceptCookiesButton() {
        Utils.sleepSeconds(3000);
        acceptCookiesButton.click();
    }

    public CookieBarPage(WebDriver driver) {
        super(driver);
    }
}
