package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchContext {
    @FindBy(xpath = "//summary[@aria-label='Search']")
    private WebElement SearchIcon;

    @FindBy(xpath = "//input[@id='Search-In-Modal']")
    private WebElement SearchField;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement SearchButton;

    @FindBy(xpath="//div[@id='FacetsWrapperDesktop']/descendant::span[text()='Product type']")
    private WebElement Producttype;

    @FindBy(xpath = "//div[@id='FacetsWrapperDesktop']/descendant::span[text()='Product type']/ancestor::summary/following-sibling::div/descendant::label[@for='Filter-Product type-1']")
    private WebElement Select1product;

    @FindBy(xpath = "//div[@class='card-wrapper']")
    public List<WebElement> Productcount;

    public SearchContext(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void Search(String Product) throws InterruptedException {
        SearchIcon.click();
        SearchField.sendKeys(Product);
        SearchButton.click();
        Thread.sleep(2000);
        Producttype.click();
        Select1product.click();
        Thread.sleep(2000);

    }
    public String SearchText(){
        String productName = Select1product.getText();
        return productName;
    }

    public int ProductCount(){
       return Productcount.size();
    }

}
