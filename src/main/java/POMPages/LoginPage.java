package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//a[@class='header__icon header__icon--account link focus-inset small-hide']")
    private WebElement AccountIcon;

    @FindBy(xpath = "//input[@id='CustomerEmail']")
    private WebElement Emailid;

    @FindBy(xpath = "//input[@id='CustomerPassword']")
    private WebElement Password;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement LoginButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    private WebElement Forgotpassword;

    @FindBy(xpath = "//h3[@class='form__message']")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//a[contains(text(),'Create account')]")
    private WebElement CreateAccountLink;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void LoginAccount(String emailId, String password){
        Emailid.sendKeys(emailId);
        Password.sendKeys(password);
        LoginButton.click();
    }
    public void forgotpassword(){
        Forgotpassword.click();
    }
    public WebElement getErrorMessage(){
        return ErrorMessage;
    }
    public WebElement getCreateAccountLink(){
        return CreateAccountLink;
    }
}
