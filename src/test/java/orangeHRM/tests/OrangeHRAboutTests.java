package orangeHRM.tests;

import framework.BaseTest;
import io.qameta.allure.*;
import orangeHRM.pageobjects.AboutUs.AboutUsPage;
import orangeHRM.pageobjects.CookieBar.CookieBarPage;
import orangeHRM.pageobjects.HomePage.OrangeHRHomepage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Utils;
import utils.listeners.TestNGListener;

@Listeners(TestNGListener.class)
@Epic("Regression Tests")
@Feature("About us Tests")
public class OrangeHRAboutTests extends BaseTest {

    @Test(priority = 1, description = "About Us Page.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: About us Page.")
    @Story("About Us Page text verification")
    public void aboutUsTest() {
        getDriver().get("https://www.orangehrm.com/");

        CookieBarPage cookieBarPage = new CookieBarPage(getDriver());
        OrangeHRHomepage orangeHRHomepage = new OrangeHRHomepage(getDriver());
        AboutUsPage aboutUsPage = new AboutUsPage(getDriver());

        cookieBarPage.clickAcceptCookiesButton();

        orangeHRHomepage.clickCompanyOption();
        orangeHRHomepage.clickAboutUsOption();

        Assert.assertEquals(aboutUsPage.getPageHeader(), Utils.getPropertyValue("pageTexts.properties","AboutUSPageHeader"));
        Assert.assertEquals(aboutUsPage.getPageHeaderSubText(),Utils.getPropertyValue("pageTexts.properties","AboutUsPageHeaderSubText"));
        Assert.assertEquals(aboutUsPage.getDescriptionTextBlock(),Utils.getPropertyValue("pageTexts.properties","AboutUsDescriptionTextBlock"));
        Assert.assertEquals(aboutUsPage.getPageSecondHeader(),Utils.getPropertyValue("pageTexts.properties","AboutUsageSecondHeader"));
    }
}
