package pageobjects.homepage;

import framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRHomepage extends BasePage {

    @FindBy(xpath = "//*[@class=\"d-flex web-menu-btn\"]/ul[@class=\"nav navbar-nav navbar-right extended-nav\"]/li/a[@href=\"hris-hr-software-demo/\"]")
    private WebElement bookAFreeDemo;

    public void clickBookAFreeDemoButton(){
        bookAFreeDemo.click();
    }

    public OrangeHRHomepage(WebDriver driver) {
        super(driver);
    }


}
