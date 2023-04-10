package orangeHRM.tests;

import framework.BaseTest;
import io.qameta.allure.*;
import orangeHRM.pageobjects.BookAFreeDemoPage.BookAFreeDemoPage;
import orangeHRM.pageobjects.GoogleCaptcha.GoogleCaptcha;
import orangeHRM.pageobjects.HomePage.OrangeHRHomepage;
import org.testng.Assert;
import orangeHRM.pageobjects.CookieBar.CookieBarPage;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import utils.Utils;
import utils.listeners.TestNGListener;

import java.util.Properties;

@Listeners(TestNGListener.class)
@Epic("Regression Tests")
@Feature("HomePage Tests")
public class OrangeHRRequestDemoTests extends BaseTest {

    @Test(priority = 1, description = "Request Free Demo.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Request Free Demo.")
    @Story("Submit a request for free demo")
    public void requestFreeDemoTest() {
        getDriver().get("https://www.orangehrm.com/");

        CookieBarPage cookieBarPage = new CookieBarPage(getDriver());
        OrangeHRHomepage orangeHRHomepage = new OrangeHRHomepage(getDriver());
        BookAFreeDemoPage bookAFreeDemoPage = new BookAFreeDemoPage(getDriver());
        GoogleCaptcha googleCaptcha = new GoogleCaptcha(getDriver());

        cookieBarPage.clickAcceptCookiesButton();

        orangeHRHomepage.clickBookAFreeDemoButton();

        Assert.assertEquals(bookAFreeDemoPage.getDemoPageHeaderTextBlock(), Utils.getPropertyValue("pageTexts.properties","DemoPageHeader"));
        Assert.assertEquals(bookAFreeDemoPage.getDemoPageDescriptionTextBlock(),Utils.getPropertyValue("pageTexts.properties","DemoPageDescriptionText"));

        bookAFreeDemoPage.typeIntoFullNameTextInputBox(Utils.getPropertyValue("testUserDetails.properties","FullName"));
        bookAFreeDemoPage.typeIntoBusinessEmailTextInputBox(Utils.getPropertyValue("testUserDetails.properties","Email"));
        bookAFreeDemoPage.selectCountryDropDown(Utils.getPropertyValue("testUserDetails.properties","Country"));
        bookAFreeDemoPage.typeIntoContactTextInputBox(Utils.getPropertyValue("testUserDetails.properties","Contact"));

        googleCaptcha.clickReadCaptchaCheckBox();

        bookAFreeDemoPage.clickSubmitButton();

        Assert.assertEquals(bookAFreeDemoPage.getThankYouMessageTextBlock(),Utils.getPropertyValue("pageTexts.properties","ThankYouMessage"));
    }
}
