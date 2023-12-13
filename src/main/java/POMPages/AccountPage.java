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

    @FindBy(xpath = "//td[@id='RowOrder']/a")
    private WebElement OrderId;

    @FindBy(xpath = "//h2[text()='Order #1074']")
    private WebElement OrderDetailsId;

    @FindBy(xpath = "//td[@data-label='Total']")
    private WebElement TotalPrice;

    @FindBy(xpath = "//tfoot/descendant::td[@data-label='Total']")
    private WebElement DeatiasTotalPrice;

    @FindBy(xpath = "//td[@headers='RowOrder ColumnDate']")
    private WebElement DateandTime;

    @FindBy(xpath = "//time")
    private WebElement DetailsDateandTime;

    @FindBy(xpath = "//h2[text()='Order history']")
    private WebElement Title;

    @FindBy(xpath = "//p[text()='Siva Kumar']")
    private WebElement AccountName;

    @FindBy(xpath = "//h1[text()='Account']/following-sibling::a")
    private WebElement LogoutButton;

    @FindBy(xpath = "//form[@id='create_customer']/input/following-sibling::h2")
    private WebElement LoginErrorMessgae;

    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
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
    public WebElement getOrderIdElement(){
        return OrderId;
    }
    public WebElement getOrderDetailsIdElement(){
        return OrderDetailsId;
    }
    public String getTotalPrice(){
        return TotalPrice.getText();
    }
    public String getDeatialsTotalPrice(){
        return DeatiasTotalPrice.getText();
    }
    public String getDataandTime(){
        return DateandTime.getText();
    }
    public String getDetailsDataandTime(){
        return DetailsDateandTime.getText();
    }
    public WebElement getTitile(){
        return Title;
    }
    public WebElement getAccountName(){
        return AccountName;
    }
    public void getLogout(){
        LogoutButton.click();
    }
    public String ErrorMessage(){
        return LoginErrorMessgae.getText();
    }
}
