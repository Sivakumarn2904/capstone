import GenericUtils.Baseclass;
import GenericUtils.JSON;
import GenericUtils.LogHelper;
import POMPages.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;

public class ExpandingTestScenariosforComprehensiveCoverage extends Baseclass {
    CreateAccount Caccount;

    AddCartPopUp addtocart;
    CartPage cart;
    Random random;
    SearchContext search;
    ProductDescriptionPage pd;

    @Test
    public void verifyUserRegistration() throws InterruptedException {

//        HomePage home=new HomePage(driver);
        home.profileIcon();
        random = new Random();
        int numbers = random.nextInt(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Create account')]")).click();
        Caccount.createAccount("Siva", "Kumar", "siva" + numbers + "@gmail.com", "Sivakumar");
        home.profileIcon();
        String name = driver.findElement(By.xpath("//p[text()='Siva Kumar']")).getText();
        Assert.assertEquals(name, "Siva Kumar");
        driver.findElement(By.xpath("//h1[text()='Account']/following-sibling::a")).click();
        Caccount = new CreateAccount(driver);
        home.profileIcon();
        int numbers1 = random.nextInt(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Create account')]")).click();
        Caccount.createAccount("", "", "", "");
        String promtmessgae = driver.findElement(By.xpath("//form[@id='create_customer']/input/following-sibling::h2")).getText();
        Assert.assertEquals(promtmessgae, "Please adjust the following:");
    }

    @Test
    public void ProductSearchnadFiltering() throws InterruptedException {

        search = new SearchContext(driver);
        search.Search("Bags");
        ((JavascriptExecutor) driver).executeScript("document.body.click();");
        String PName = search.SearchText();
        int number = 0;
        for (int i = 0; i < PName.length(); i++) {
            if (PName.charAt(i) >= '0' && PName.charAt(i) <= '9') {
                number += Integer.parseInt(PName.charAt(i) + "");
            }
        }
        int pCount = search.ProductCount();
        Assert.assertEquals(number, pCount);
    }

    @Test
    public void CartandCheckoutProcess() throws InterruptedException, IOException, ParseException {
        WebElement Productelements = driver.findElement(By.xpath("//a[contains(.,'15mm Combo Wrench')]"));
        wait.until(ExpectedConditions.visibilityOf(Productelements));
        Productelements.click();
        WebElement element = driver.findElement(By.xpath("//button[@class='product-form__submit button button--full-width button--secondary']"));
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")) {
            System.out.println("This product is Sold out");
        } else {
            element.click();
            Thread.sleep(3000);
            WebElement promtMessage = driver.findElement(By.xpath("//div[@class='cart-notification__header']"));
            Assert.assertEquals(promtMessage.getText(), "Item added to your cart");
            Thread.sleep(3000);
            String cartCount = driver.findElement(By.xpath("//a[@id='cart-notification-button']")).getText();
            Assert.assertEquals(cartCount, "View my cart (1)");
            addtocart = new AddCartPopUp(driver);
            addtocart.countinueShopping();
            HomePage home = new HomePage(driver);
            home.addCartIcon();
            cart = new CartPage(driver);
            cart.countinueShopping();
            driver.findElement(By.xpath("//a[normalize-space()='16 Ti Skis']")).click();
            pd = new ProductDescriptionPage(driver);
            pd.addToCart();
            Thread.sleep(2000);
            addtocart.ViewMyCart();
            List<WebElement> ActualAmount = driver.findElements(By.xpath("//td[@class='cart-item__totals right small-hide']/descendant::span"));
            double actnu = 0;
            for (WebElement price : ActualAmount) {

                String Actualprice = price.getText();
                String[] act = Actualprice.split(" ");
                actnu += Double.parseDouble(act[1]);
            }
            String ExpAmount = driver.findElement(By.xpath("//h3[text()='Subtotal']/following-sibling::p")).getText();
            String DiscountAmount = driver.findElement(By.xpath("//li[@class='discounts__discount discounts__discount--end']")).getText();

            String[] exp = ExpAmount.split(" ");
            double expnu = Double.parseDouble(exp[1]);
            double dis = actnu - expnu;
            String discountprice = String.valueOf(dis);
            Assert.assertTrue(DiscountAmount.contains(discountprice));
            WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
            Thread.sleep(3000);
            checkoutButton.click();
            Thread.sleep(5000);
            JSON data = new JSON();
            String Emailid = data.fetchData("emailId");
            String Password = data.fetchData("password");
            try {
                LogHelper.logInfo("Entering the method LoggingMechanism.");
                LoginPage login = new LoginPage(driver);
                login.LoginAccount(Emailid, Password);
                LogHelper.logInfo("Exiting the method LoggingMechanism.");
            } catch (Exception e) {
                LogHelper.logError("An error occurred: " + e.getMessage());
            }
        }
    }

    @Test
    public void profileUpdate() throws IOException, ParseException, InterruptedException {
        home.profileIcon();
        JSON data = new JSON();
        String Emailid = data.fetchData("emailId");
        String Password = data.fetchData("password");
        login.LoginAccount(Emailid, Password);
        Thread.sleep(30000);
        account.viewAddress().click();
        account.editButton();
        String Firstname = data.fetchData("firstName");
        String Lastname = data.fetchData("lastName");
        String Company = data.fetchData("company");
        account.editAddress(Firstname, Lastname, Company);
        account.updateButton();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", account.updateButton());
        Assert.assertEquals(Firstname + " " + Lastname, account.getupdatedetails().contains(Firstname + " " + Lastname));
    }

    @Test
    public void OutofStockProducts() throws InterruptedException {
        home.FirstProduct();
//        WebElement Productelements = driver.findElement(By.xpath("//a[contains(.,'12 Ti Xelium Skis')]"));
//        wait.until(ExpectedConditions.visibilityOf(Productelements));
//        Productelements.click();
        WebElement element = pd.SoldOrCart();
//        WebElement element = driver.findElement(By.xpath("//button[@class='product-form__submit button button--full-width button--secondary']"));
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")) {
            System.out.println("This product is Sold out");
        } else {
            element.click();
        }
    }

    @Test
    public void ForgotPassword() throws IOException, ParseException {
        home.profileIcon();
        login.forgotpassword();
        JSON data = new JSON();
        String Emailid = data.fetchData("emailId");
        reset.emailId(Emailid);
        reset.submitButton();
        String errormessage = login.getErrorMessage().getText();
        Assert.assertEquals(errormessage, errormessage.contains("We've sent you an email with a link to update your password"));
    }

    @Test
    public void OrderHistoryandDetailsAccuracy() throws IOException, ParseException, InterruptedException {
        home.profileIcon();
        JSON data = new JSON();
        String Emailid = data.fetchData("emailId");
        String Password = data.fetchData("password");
        login.LoginAccount(Emailid,Password);
        Thread.sleep(30000);
        String orderId = account.getOrderIdElement().getText();
        String Totalprice = account.getTotalPrice();
        wait.until(ExpectedConditions.elementToBeClickable(account.getOrderIdElement()));
        account.getOrderIdElement().click();
        String OrderDetailsId=account.getOrderDetailsIdElement().getText();
        wait.until(ExpectedConditions.visibilityOf(account.getOrderDetailsIdElement()));
        Assert.assertTrue(OrderDetailsId.contains(orderId));
        Assert.assertEquals(Totalprice,account.getDeatialsTotalPrice());

    }
}
