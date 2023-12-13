package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

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

    @FindBy(xpath = "//a[@id='cart-icon-bubble']")
    private WebElement CartIcon;

    @FindBy(xpath = "//a[contains(.,'15mm Combo Wrench')]")
    private WebElement ProductName;
    @FindBy(xpath = "//a[contains(.,'12 Ti Xelium Skis')]")
    private WebElement FirstProductName;

    @FindBy(xpath = "//a[contains(.,'15mm Combo Wrench')]")
    private WebElement SecondProductName;

    @FindBy(xpath = "//a[normalize-space()='16 Ti Skis']")
    private WebElement ThirdProductName;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void productClick() {

        ProductName.click();
    }

    public void addCartIcon() {
        CartIcon.click();
    }
    public WebElement addCartIconelement() {
        return CartIcon;
    }

    public void profileIcon() {
        AccountIcon.click();
    }
    public String FirstProduct() {
        String fpname=FirstProductName.getText();
        FirstProductName.click();
        return fpname;
    }
    public WebElement Secondproduct() {
       return SecondProductName;
    }
    public WebElement Thirdproduct() {
        return ThirdProductName;
    }
}
