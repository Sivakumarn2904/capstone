package GenericUtils;

import POMPages.AddCartPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Baseclass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver selectBrowser(String browser)
    {
        switch (browser) {
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver=new InternetExplorerDriver();
                break;

            default:
                System.out.println("Please enter the browser");
                break;
        }
        return driver;
    }
    public WebDriver closeBrowser(){
        driver.quit();
        return driver;
    }
    @BeforeMethod
    public void launch(){
        driver=selectBrowser("chrome");
//         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web-playground.ultralesson.com/");
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void close(){
        closeBrowser();
        //driver.quit();
    }
}
