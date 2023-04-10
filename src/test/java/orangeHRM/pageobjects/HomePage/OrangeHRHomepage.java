package orangeHRM.pageobjects.HomePage;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRHomepage extends BasePage {

    @FindBy(xpath = "//*[@class=\"d-flex web-menu-btn\"]/ul[@class=\"nav navbar-nav navbar-right extended-nav\"]/li/a[@href=\"hris-hr-software-demo/\"]")
    private WebElement bookAFreeDemo;

    @FindBy(xpath = "//*[@id='navbarSupportedContent']/ul/li[4]/a")
    private WebElement companyOption;

    @FindBy(xpath = "//*[@id='navbarSupportedContent']/ul/li[4]//ul/li[1]/a")
    private WebElement aboutUsOption;

    public void clickBookAFreeDemoButton(){
        bookAFreeDemo.click();
    }

    public void clickCompanyOption(){
        companyOption.click();
    }

    public void clickAboutUsOption(){
        aboutUsOption.click();
    }

    public OrangeHRHomepage(WebDriver driver) {
        super(driver);
    }


}
