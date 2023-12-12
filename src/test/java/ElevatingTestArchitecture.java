import GenericUtils.Baseclass;
import GenericUtils.DriverFactory;
import GenericUtils.JSON;
import GenericUtils.LogHelper;
import POMPages.HomePage;
import POMPages.LoginPage;
import POMPages.ProductDescriptionPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ElevatingTestArchitecture extends Baseclass {
    @Test
    public void addCart(){
        home.productClick();
       pd.addToCart();
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

        home.profileIcon();
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
    @Test
    public void DataDrivenTesting() throws IOException, ParseException {
        String Emailid = data.fetchData("emailId");
        String Password = data.fetchData("password");
        try {
            LogHelper.logInfo("Entering the method LoggingMechanism.");
            home.profileIcon();
            login.LoginAccount(Emailid, Password);
            LogHelper.logInfo("Exiting the method LoggingMechanism.");
        }catch (Exception e){
            LogHelper.logError("An error occurred: " + e.getMessage());
        }
    }
}
