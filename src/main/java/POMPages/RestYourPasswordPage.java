package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestYourPasswordPage {

    @FindBy(xpath = "//input[@id='RecoverEmail']")
    private WebElement Emailid;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement SubmitButton;

    public RestYourPasswordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void emailId(String emailid){
        Emailid.sendKeys(emailid);
    }
    public void submitButton(){
        SubmitButton.click();
    }
}
