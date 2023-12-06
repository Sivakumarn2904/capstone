import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Add_Cart extends Baseclass{

    @Test
    public void velidateProductDeatialsPage() throws InterruptedException {

        WebElement product = driver.findElement(By.xpath("//a[contains(.,'12 Ti Xelium Skis')]"));
        String plpProductName = product.getText();
        product.click();
        String pdpProductName = driver.findElement(By.xpath("//h1[contains(.,'12 Ti Xelium Skis')]")).getText();
        Assert.assertEquals(plpProductName,pdpProductName);
    }
    @Test
    public void verifyTheProductIsAdded() throws InterruptedException {

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
    }

    @Test
    public void verifyProductAvailability() throws InterruptedException {

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
    }

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
            WebElement productName = driver.findElement(By.xpath("//h1[@class='product__title']"));
            Assert.assertEquals(Productelements.getText(),productName);
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
            Assert.assertTrue(DiscountPrice.contains(DiscountPrice+""));
        }

    }

    @Test
    public void verifyTheProductRemoveFromCart() throws InterruptedException {
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
            Assert.assertEquals(promtMessage.getText(), "Item added to your cart");
            Thread.sleep(3000);
            String cartCount = driver.findElement(By.xpath("//a[@id='cart-notification-button']")).getText();
            Assert.assertEquals(cartCount, "View my cart (1)");

            driver.findElement(By.xpath("//a[@id='cart-notification-button']")).click();
            driver.findElement(By.xpath("//*[name()='svg' and @class='icon icon-remove']")).click();
            String emptyMessgae = driver.findElement(By.xpath("//a[text()='Continue shopping']")).getText();
            Assert.assertEquals(emptyMessgae, "Continue shopping");
        }
    }

}
