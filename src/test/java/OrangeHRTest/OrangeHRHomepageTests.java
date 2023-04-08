package OrangeHRTest;

import framework.core.BaseTest;
import pageobjects.BookAFreeDemoPage.BookAFreeDemoPage;
import pageobjects.GoogleCaptcha.GoogleCaptcha;
import pageobjects.homepage.OrangeHRHomepage;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(listeners.TestNGListener.class)
public class OrangeHRHomepageTests extends BaseTest {

    @Test
    public void requestFreeDemoTest() {
        getDriver().get("https://www.orangehrm.com/");

//        CookieBarPage cookieBarPage = new CookieBarPage(getDriver());
        OrangeHRHomepage orangeHRHomepage = new OrangeHRHomepage(getDriver());
        BookAFreeDemoPage bookAFreeDemoPage = new BookAFreeDemoPage(getDriver());
        GoogleCaptcha googleCaptcha = new GoogleCaptcha(getDriver());

//        cookieBarPage.clickAcceptCookiesButton();

        orangeHRHomepage.clickBookAFreeDemoButton();

        bookAFreeDemoPage.typeIntoFullNameTextInputBox("John Doe");
        bookAFreeDemoPage.typeIntoBusinessEmailTextInputBox("john.doe@gmail.com");
        bookAFreeDemoPage.selectCountryDropDown("Malaysia");
        bookAFreeDemoPage.typeIntoContactTextInputBox("0123456789");

        googleCaptcha.clickReadCaptchaCheckBox();

        bookAFreeDemoPage.clickSubmitButton();
    }
}
