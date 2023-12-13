package testcases;

import GenericUtils.Baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_Cart extends Baseclass {

    @Test
    public void velidateProductDeatialsPage() throws InterruptedException {
        String product =home.FirstProduct();
        String pdpname = pd.getProductname();
        Assert.assertEquals(product,pdpname);
    }
    @Test
    public void verifyProductAvailability() throws InterruptedException {
        home.FirstProduct();
        WebElement element=pd.SoldOrCart();
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")){
            System.out.println("This product is Sold out");
        }else {
            element.click();
        }
    }

    @Test
    public void verifyTheProductIsAdded() throws InterruptedException {
        WebElement Sname = home.Secondproduct();
        wait.until(ExpectedConditions.elementToBeClickable(Sname));
        Sname.click();
        WebElement SoldOrCartbutton = pd.SoldOrCart();
        String soldoutElement=SoldOrCartbutton.getText();
        if (soldoutElement.contains("Sold out")){
            System.out.println("This product is Sold out");
        }else {
            SoldOrCartbutton.click();
            wait.until(ExpectedConditions.visibilityOf(addtocartpopup.getSuccessmessage()));
            String Successmessage = addtocartpopup.getSuccessmessage().getText();
            Assert.assertEquals(Successmessage,"Item added to your cart"); // this is the code for validating items added to your cart
            wait.until(ExpectedConditions.visibilityOf(addtocartpopup.getcartnotification()));
            Assert.assertEquals(addtocartpopup.getcartnotification().getText(),"View my cart (1)");
        }
    }


    @Test
    public void verifyTheCartDeatials() throws InterruptedException {

        WebElement  Productelements= home.Secondproduct();
        String pname = Productelements.getText();
        wait.until(ExpectedConditions.visibilityOf(Productelements));
        Productelements.click();
        WebElement element=pd.SoldOrCart();
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")) {
            System.out.println("This product is Sold out");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            WebElement productName= pd.getProductTitle();
            String productQuantity=pd.getProductQuantity().getText();
            Assert.assertEquals(pname,productName.getText());
            wait.until(ExpectedConditions.visibilityOf(addtocartpopup.getSuccessmessage()));
            wait.until(ExpectedConditions.elementToBeClickable(home.addCartIconelement()));
            home.addCartIcon();
            Assert.assertTrue(cart.getCartPageTitle().isDisplayed());
            Assert.assertTrue(cart.getProductName().isDisplayed(),cart.getProductName().getText());
            Assert.assertEquals(productQuantity,cart.getProductQuantity().getText());
            String ExpectPrice = cart.getExpectPrice().getText();
            String ActualPrice= cart.getActualPrice().getText();
            String DiscountPrice=cart.getDiscountPrice().getText();
            String[] exp = ExpectPrice.split(" ");
            String[] act = ActualPrice.split(" ");
            double expnu = Double.parseDouble(exp[1]);
            double actnu = Double.parseDouble(act[1]);
            double discount =  actnu - expnu ;
            String discountprice = String.valueOf(discount);
            String[] dis = discountprice.split(String.valueOf(0), 4);
            Assert.assertTrue(DiscountPrice.contains(dis[1]));
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
