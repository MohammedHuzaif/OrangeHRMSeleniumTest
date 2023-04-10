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
import utils.listeners.TestNGListener;

@Listeners(TestNGListener.class)
@Epic("Regression Tests")
@Feature("HomePage Tests")
public class OrangeHRHomepageTests extends BaseTest {

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
