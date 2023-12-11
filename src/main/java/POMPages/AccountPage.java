package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    @FindBy(xpath = "//a[contains(text(),'View addresses')]")
    private WebElement viewAddress;

    @FindBy(xpath = "//button[@aria-label='Edit address 1']")
    private WebElement EditButton;

    @FindBy(xpath = "//div[@id='EditAddress_8604619210973']/descendant::input[@name='address[first_name]']")
    private WebElement Firstname;

    @FindBy(xpath = "//div[@id='EditAddress_8604619210973']/descendant::input[@name='address[last_name]']")
    private WebElement Lastname;

    @FindBy(xpath = "//div[@id='EditAddress_8604619210973']/descendant::input[@name='address[company]']")
    private WebElement Company;

    @FindBy(xpath = "//div[@id='EditAddress_8604619210973']/descendant::button[text()='Update address']")
    private WebElement UpadateButton;

    @FindBy(xpath = "//li[@data-address][1]/child::p")
    private WebElement UpdateElement;
    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver,this
        );
    }

    public WebElement viewAddress(){
       return viewAddress;
    }

    public void editButton() throws InterruptedException {
        EditButton.click();
    }
    public void editAddress(String firstname,String lastname,String company){
        Firstname.sendKeys(firstname);
        Lastname.sendKeys(lastname);
        Company.sendKeys(company);
    }
    public WebElement updateButton(){
        return UpadateButton;
    }
    public String getupdatedetails(){
        return  UpdateElement.getText();
    }

}
