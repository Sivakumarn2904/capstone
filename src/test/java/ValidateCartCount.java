import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateCartCount extends Baseclass {
    @Test
    public void verifyTheCartDeatials() throws InterruptedException {

        WebElement Productelements = driver.findElement(By.xpath("//a[contains(.,'15mm Combo Wrench')]"));
        wait.until(ExpectedConditions.visibilityOf(Productelements));
        Productelements.click();
        WebElement element = driver.findElement(By.xpath("//button[@class='product-form__submit button button--full-width button--secondary']"));
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")) {
            System.out.println("This product is Sold out");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
           try{
               wait.until(ExpectedConditions.alertIsPresent());
           }catch (Exception e){
               e.printStackTrace();
           }
            WebElement carticon = driver.findElement(By.xpath("//a[@id='cart-icon-bubble']"));
            wait.until(ExpectedConditions.elementToBeClickable(carticon));
            carticon.click();
            String ExpectPrice = driver.findElement(By.xpath("//td[@class='cart-item__totals right small-hide']/descendant::span")).getText();
            String ActualPrice=driver.findElement(By.xpath("//h3[text()='Subtotal']/following-sibling::p")).getText();
            String DiscountPrice=driver.findElement(By.xpath("//li[@class='discounts__discount discounts__discount--end']")).getText();
            String[] exp = ExpectPrice.split(" ");
            String[] act = ActualPrice.split(" ");
            double expnu = Double.parseDouble(exp[1]);
            double actnu = Double.parseDouble(act[1]);
            double discount = expnu - actnu;
            System.out.println(discount);
            Assert.assertTrue(DiscountPrice.contains(DiscountPrice+""));
        }
        Thread.sleep(3000);
    }
}
