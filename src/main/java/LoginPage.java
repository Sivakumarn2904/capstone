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

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void LoginAccount(String emailId, String password){
        Emailid.sendKeys(emailId);
        Password.sendKeys(password);
        LoginButton.click();
    }
}
