package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPopUp {

    @FindBy(xpath = "//button[text()='Continue shopping']")
    private WebElement CountinueShopping;

    @FindBy(xpath = "//button[text()='Check out']")
    private WebElement Checkout;

    @FindBy(xpath = "//a[@id='cart-notification-button']")
    private WebElement AddCart;

    @FindBy(xpath = "//h3[@class='cart-notification-product__name h4']")
    private WebElement productName;

    public AddCartPopUp(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void countinueShopping(){
        CountinueShopping.click();
    }
    public void ViewMyCart(){
        AddCart.click();
    }

}
