package orangeHRM.pageobjects.AboutUs;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage {

    @FindBy(css ="section h1")
    private WebElement pageHeader;

    @FindBy(xpath ="//section[1]//p")
    private WebElement pageHeaderSubText;

    @FindBy(xpath ="//section[2]//p")
    private WebElement descriptionTextBlock;

    @FindBy(xpath ="//section[3]//h2")
    private WebElement pageSecondHeader;

    @FindBy(xpath ="//section[3]//p")
    private WebElement pageSecondHeaderSubText;

    public String getPageHeader(){
        return pageHeader.getText();
    }

    public String getPageHeaderSubText(){
        return pageHeaderSubText.getText();
    }

    public String getDescriptionTextBlock(){
        return descriptionTextBlock.getText();
    }

    public String getPageSecondHeader(){
        return pageSecondHeader.getText();
    }

    public String getPageSecondHeaderSubText(){
        return pageSecondHeaderSubText.getText();
    }

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }
}
