package testcases;

import GenericUtils.Baseclass;

import GenericUtils.DriverFactory;
import GenericUtils.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_Cart extends Baseclass {
    /**
     * Here the verifying the product details page
     */
    @Test
    public void velidateProductDeatialsPage() throws InterruptedException {
        String product =home.FirstProduct();
        String pdpname = pd.getProductname();
        Assert.assertEquals(product,pdpname);
    }
    /**
     * Here the verifying the product availability
     */
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

    /**
     * Here the product is adding to the cart page
     */
    @Test
    public void verifyTheProductIsAdded()  {
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

    /**
     * Here the product cart details page
     */
    @Test
    public void verifyTheCartDetails() {

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
        WebElement Productelements =home.Secondproduct();
        wait.until(ExpectedConditions.visibilityOf(Productelements));
        Productelements.click();
        WebElement element= pd.SoldOrCart();
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")){
            System.out.println("This product is Sold out");
        }else {
            element.click();
            wait.until(ExpectedConditions.visibilityOf(addtocartpopup.getSuccessmessage()));
            Assert.assertEquals(addtocartpopup.getSuccessmessage().getText(), "Item added to your cart");
            Assert.assertEquals(addtocartpopup.getcartnotification().getText(), "View my cart (1)");
            addtocartpopup.getcartnotification().click();
            cart.ProductDelete();
            wait.until(ExpectedConditions.visibilityOf(cart.getEmptyText()));
            Assert.assertEquals(cart.getEmptyText().getText(), "Your cart is empty");
            DriverFactory.getInstance();

        }
    }

}
