import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductAvailability {

    @Test
    public void verifyProductAvailability() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web-playground.ultralesson.com/");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement Productelements = driver.findElement(By.xpath("//a[contains(.,'12 Ti Xelium Skis')]"));
        wait.until(ExpectedConditions.visibilityOf(Productelements));
        Productelements.click();
        WebElement element = driver.findElement(By.xpath("//button[@class='product-form__submit button button--full-width button--secondary']"));
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")){
            System.out.println("This product is Sold out");
        }else {
            element.click();
        }
        Thread.sleep(5000);
        driver.quit();

    }
}
