import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ElevatingTestArchitecture extends Baseclass {
    HomePage home;
    @Test
    public void addCart(){
         home = new HomePage(driver);
        home.productClick();
        new ProductDescriptionPage(driver).addToCart();
        home.addCartIcon();
    }
}
