import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckProductAdded {

    @Test

    public void verifyTheProductIsAdded() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web-playground.ultralesson.com/");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement Productelements = driver.findElement(By.xpath("//a[contains(.,'15mm Combo Wrench')]"));
        wait.until(ExpectedConditions.visibilityOf(Productelements));
        Productelements.click();
        WebElement element = driver.findElement(By.xpath("//button[@class='product-form__submit button button--full-width button--secondary']"));
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")){
            System.out.println("This product is Sold out");
        }else {
            element.click();
            Thread.sleep(3000);
            WebElement promtMessage = driver.findElement(By.xpath("//div[@class='cart-notification__header']"));
            Assert.assertEquals(promtMessage.getText(),"Item added to your cart");
            Thread.sleep(3000);
            String cartCount = driver.findElement(By.xpath("//a[@id='cart-notification-button']")).getText();
            Assert.assertEquals(cartCount,"View my cart (1)");
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
