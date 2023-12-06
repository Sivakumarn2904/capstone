import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateAccount {
    @FindBy(xpath = "//input[@id='RegisterForm-FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='RegisterForm-LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='RegisterForm-email']")
    private WebElement emailId;

    @FindBy(xpath ="//input[@id='RegisterForm-password']")
    private WebElement Password;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement createButton;

    public CreateAccount(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void createAccount(String firstname, String lastname, String emailid, String password){
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        emailId.sendKeys(emailid);
        Password.sendKeys(password);
        createButton.click();
    }

}
