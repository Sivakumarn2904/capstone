package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(xpath = "//a[text()='Continue shopping']")
    private WebElement Continueshopping;

    @FindBy(xpath = "//td[@class='cart-item__totals right small-hide']/descendant::span")
    private WebElement ActualPrice;

    @FindBy(xpath = "//h3[text()='Subtotal']/following-sibling::p")
    private WebElement ExceptPrice;
    @FindBy(xpath = "//li[@class='discounts__discount discounts__discount--end']")
    private WebElement DiscountPrice;

    @FindBy(xpath = "//h1[@class='title title--primary']")
    private WebElement CartPageTitle;

    @FindBy(xpath = "//a[@class='cart-item__name h4 break']")
    private WebElement ProductName;

    @FindBy(xpath = "//input[@class='quantity__input']")
    private WebElement ProductQuantity;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void countinueShopping(){
        Continueshopping.click();
    }
    public WebElement getActualPrice(){
        return ActualPrice;
    }
    public WebElement getExpectPrice(){
        return ExceptPrice;
    }
    public WebElement getDiscountPrice(){
        return DiscountPrice;
    }
    public WebElement getCartPageTitle(){
        return CartPageTitle;
    }
    public WebElement getProductName(){
        return ProductName;
    }
    public WebElement getProductQuantity(){
        return ProductQuantity;
    }

}
