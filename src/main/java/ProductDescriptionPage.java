import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage {
    @FindBy(xpath = "//span[@class='header__active-menu-item']")
    private WebElement HomeTab;

    @FindBy(xpath = "//span[text()='Store']")
    private WebElement StoreTab;

    @FindBy(xpath = "//span[text()='Contact']")
    private WebElement ContactTab;

    @FindBy(xpath = "//summary[@aria-label='Search']")
    private WebElement SearchIcon;

    @FindBy(xpath = "//a[@class='header__icon header__icon--account link focus-inset small-hide']")
    private WebElement AccountIcon;

    @FindBy(xpath ="//a[@id='cart-icon-bubble']")
    private WebElement CartIcon;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement AddtocartButton;

    @FindBy(xpath = "//div[@data-shopify='payment-button']")
    private WebElement BuynowButton;


    public ProductDescriptionPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void addToCart(){
        AddtocartButton.click();
    }
}
