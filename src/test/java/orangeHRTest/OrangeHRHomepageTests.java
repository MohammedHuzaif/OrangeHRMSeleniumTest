package orangeHRTest;

import framework.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.BookAFreeDemoPage.BookAFreeDemoPage;
import pageobjects.CookieBar.CookieBarPage;
import pageobjects.GoogleCaptcha.GoogleCaptcha;
import pageobjects.homepage.OrangeHRHomepage;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import utils.listeners.TestNGListener;

@Listeners(TestNGListener.class)
@Epic("Regression Tests")
@Feature("HomePage Tests")
public class OrangeHRHomepageTests extends BaseTest {

    @Test(priority = 1, description = "Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Request Free Demo.")
    @Story("Submit a request for free demo")
    public void requestFreeDemoTest() {
        getDriver().get("https://www.orangehrm.com/");

        CookieBarPage cookieBarPage = new CookieBarPage(getDriver());
        OrangeHRHomepage orangeHRHomepage = new OrangeHRHomepage(getDriver());
        BookAFreeDemoPage bookAFreeDemoPage = new BookAFreeDemoPage(getDriver());
        GoogleCaptcha googleCaptcha = new GoogleCaptcha(getDriver());

//        cookieBarPage.clickAcceptCookiesButton();

        orangeHRHomepage.clickBookAFreeDemoButton();

        Assert.assertEquals(bookAFreeDemoPage.getDemoPageHeaderTextBlock(),"Manage Your People and Operations in One Place");
        Assert.assertEquals(bookAFreeDemoPage.getDemoPageDescriptionTextBlock(),"See the endless posibilities with OrangeHRM.");

        bookAFreeDemoPage.typeIntoFullNameTextInputBox("John Doe");
        bookAFreeDemoPage.typeIntoBusinessEmailTextInputBox("john.doe@gmail.com");
        bookAFreeDemoPage.selectCountryDropDown("Malaysia");
        bookAFreeDemoPage.typeIntoContactTextInputBox("0123456789");

        googleCaptcha.clickReadCaptchaCheckBox();

        bookAFreeDemoPage.clickSubmitButton();

        Assert.assertEquals(bookAFreeDemoPage.getThankYouMessageTextBlock(),"Thank you. We’ll be contacting you shortly!");
    }
}
