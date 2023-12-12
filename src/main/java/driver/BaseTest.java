package driver;

import GenericUtils.JSON;
import POMPages.*;
import driver.Driver;
import driver.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected HomePage home;
    protected WebDriverWait wait;
    protected ProductDescriptionPage pd;

    protected AddCartPopUp addtocartpopup;

    protected LoginPage login;

    protected AccountPage account;

    protected CreateAccount Caccount;

    protected RestYourPasswordPage reset;
    protected CartPage cart;
    protected SearchContext search;
    protected JSON data;

    @BeforeMethod
    public void setup() {
        Driver.initDriver("chrome", "local");
        home = new HomePage(DriverManager.getDriver());
        pd = new ProductDescriptionPage(DriverManager.getDriver());
        addtocartpopup = new AddCartPopUp(DriverManager.getDriver());
        login = new LoginPage(DriverManager.getDriver());
        account = new AccountPage(DriverManager.getDriver());
        Caccount = new CreateAccount(DriverManager.getDriver());
        reset = new RestYourPasswordPage(DriverManager.getDriver());
        cart = new CartPage(DriverManager.getDriver());
        search = new SearchContext(DriverManager.getDriver());
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        data = new JSON();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
