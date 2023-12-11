package POMPages;

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

    @FindBy(xpath = "//h1[contains(.,'12 Ti Xelium Skis')]")
    private WebElement Productname;

    @FindBy(xpath = "//button[@class='product-form__submit button button--full-width button--secondary']")
    private WebElement SoldOrCart;
    @FindBy(xpath = "//h1[@class='product__title']")
    private WebElement productTitle;


    public ProductDescriptionPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void addToCart(){
        AddtocartButton.click();
    }
    public String getProductname() throws InterruptedException  {
        return Productname.getText();
    }
    public WebElement SoldOrCart() {
         return SoldOrCart;
    }
    public WebElement getProductTitle() {
        return productTitle;
    }
}
