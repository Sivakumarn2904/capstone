package GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Baseclass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void launch(){
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web-playground.ultralesson.com/");
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
