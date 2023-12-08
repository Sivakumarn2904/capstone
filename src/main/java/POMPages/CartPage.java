package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(xpath = "//a[text()='Continue shopping']")
    private WebElement Continueshopping;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void countinueShopping(){
        Continueshopping.click();
    }

}
