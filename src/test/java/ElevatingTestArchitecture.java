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

    @Test
    public void CentralizeDriverManagement(){
        DriverFactory driverfactory = new DriverFactory();
        driverfactory.selectBrowser("chrome");
        driverfactory.closeBrowser();
    }

}
