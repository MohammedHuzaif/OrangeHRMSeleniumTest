package pageobjects.BookAFreeDemoPage;

import framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookAFreeDemoPage extends BasePage {

    @FindBy(css = ".free-demo-page-slider-content h1") //Manage Your People and Operations in One Place
    private WebElement demoPageHeaderTextBlock;

    @FindBy(css = ".free-demo-page-description h4") //See the endless posibilities with OrangeHRM.
    private WebElement demoPageDescriptionTextBlock;

    @FindBy(css = "#Form_getForm_FullName")
    private WebElement fullNameTextInputBox;

    @FindBy(css = "#Form_getForm_Email")
    private WebElement businessEmailTextInputBox;

    @FindBy(css = "#Form_getForm_Country")
    private WebElement countryDropDown;

    @FindBy(css = "#Form_getForm_Contact")
    private WebElement contactTextInputBox;

    @FindBy(css=".thank-page-info")
    private WebElement thankYouMessageTextBlock; //Thank you. We’ll be contacting you shortly!

    @FindBy(css="#Form_getForm_action_submitForm")
    private WebElement submitButton;

    public void typeIntoFullNameTextInputBox(String fullName){
        fullNameTextInputBox.sendKeys(fullName);
    }

    public void typeIntoBusinessEmailTextInputBox(String email){
        businessEmailTextInputBox.sendKeys(email);
    }

    public void selectCountryDropDown(String country){
        countryDropDown.sendKeys(country);
    }

    public void typeIntoContactTextInputBox(String phoneNumber){
        contactTextInputBox.sendKeys(phoneNumber);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getDemoPageHeaderTextBlock(){
        return demoPageHeaderTextBlock.getText();
    }

    public String getDemoPageDescriptionTextBlock(){
        return demoPageDescriptionTextBlock.getText();
    }

    public String getThankYouMessageTextBlock(){
        return thankYouMessageTextBlock.getText();
    }

    public BookAFreeDemoPage(WebDriver driver) {
        super(driver);
    }
}
