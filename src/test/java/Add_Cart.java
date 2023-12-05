import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Add_Cart {

    @Test
    public void velidateProductDeatialsPage() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://web-playground.ultralesson.com/");
        WebElement product = driver.findElement(By.xpath("//a[contains(.,'12 Ti Xelium Skis')]"));
        String plpProductName = product.getText();
        product.click();
        String pdpProductName = driver.findElement(By.xpath("//h1[contains(.,'12 Ti Xelium Skis')]")).getText();
        Assert.assertEquals(plpProductName,pdpProductName);
        Thread.sleep(3000);
        driver.quit();

    }
}
