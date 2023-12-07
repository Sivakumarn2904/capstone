import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ElevatingTestArchitecture extends Baseclass {
    HomePage home;
    LoginPage login;
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

    @Test
    public void ActionClassesforTestSteps() throws InterruptedException {

        home = new HomePage(driver);
        home.profileIcon();
        login = new LoginPage(driver);
        login.LoginAccount("siva@gmail.com","Sivakumar");

    }

    @Test
    public void LoggingMechanism(){
       try {
           LogHelper.logInfo("Entering the method LoggingMechanism.");
           home = new HomePage(driver);
           home.profileIcon();
           login = new LoginPage(driver);
           login.LoginAccount("siva@gmail.com", "Sivakumar");
           LogHelper.logInfo("Exiting the method LoggingMechanism.");
       }catch (Exception e){
           LogHelper.logError("An error occurred: " + e.getMessage());
       }
    }

}
