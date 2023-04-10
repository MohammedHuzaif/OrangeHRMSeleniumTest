package orangeHRM.tests;

import framework.BaseTest;
import io.qameta.allure.*;
import orangeHRM.pageobjects.AboutUs.AboutUsPage;
import orangeHRM.pageobjects.CookieBar.CookieBarPage;
import orangeHRM.pageobjects.HomePage.OrangeHRHomepage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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

        Assert.assertEquals(aboutUsPage.getPageHeader(),"About OrangeHRM");
        Assert.assertEquals(aboutUsPage.getPageHeaderSubText(),"Defining the true meaning of HR for All.");
        Assert.assertEquals(aboutUsPage.getDescriptionTextBlock(),"In 2005 when OrangeHRM started we had one mission, to make HR about the people. We wanted to remove any pain our fellow HR manager might be feeling in their job. Since then we have developed a world leading open source HR software that is trusted by over 5 million users.");
        Assert.assertEquals(aboutUsPage.getPageSecondHeader(),"Our Product is Separated into Four Areas of HR");
        Assert.assertEquals(aboutUsPage.getPageSecondHeaderSubText(),"With each section we have many products that help any HR team. It doesn’t matter if you’re a team of one or a team of 20. OrangeHRM serves any company size and unique business case. With the options of customization or out of the box, you can make OrangeHRM work the way you need it to.");

    }
}
