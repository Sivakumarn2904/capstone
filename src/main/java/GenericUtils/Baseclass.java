package GenericUtils;

import POMPages.*;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Baseclass {

   protected DriverFactory driverFactory;
    protected WebDriverWait wait;

    protected HomePage home;
    protected ProductDescriptionPage pd;

    protected AddCartPopUp addtocartpopup;

    protected LoginPage login;

    protected AccountPage account;

    protected CreateAccount Caccount;

    protected RestYourPasswordPage reset;
    protected CartPage cart;
    protected SearchContext search;
    protected JSON data;
    protected Scroll scroll;

    @BeforeMethod
    public void start() {
        //new DriverFactory().selectBrowser("chrome");
//        driver= DriverManager.getDriver();
         driverFactory = DriverFactory.getInstance();
        WebDriver driver = driverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web-playground.ultralesson.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        home = new HomePage(driver);
        pd = new ProductDescriptionPage(driver);
        addtocartpopup = new AddCartPopUp(driver);
        login = new LoginPage(driver);
        account = new AccountPage(driver);
        Caccount = new CreateAccount(driver);
        reset = new RestYourPasswordPage(driver);
        cart = new CartPage(driver);
        search = new SearchContext(driver);
         data = new JSON();
         scroll = new Scroll();

    }

    @AfterMethod
    public void teardown() {
       driverFactory.closeDriver();
    }
}
