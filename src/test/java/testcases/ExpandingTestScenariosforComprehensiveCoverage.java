package testcases;

import GenericUtils.Baseclass;
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

public class ExpandingTestScenariosforComprehensiveCoverage extends Baseclass {

    Random random;

    @Test
    public void verifyUserRegistration() throws InterruptedException {

        home.profileIcon();
        random = new Random();
        int numbers = random.nextInt(1000);
        login.getCreateAccountLink().click();
        Caccount.createAccount("Siva", "Kumar", "siva" + numbers + "@gmail.com", "Sivakumar");
        home.profileIcon();
        String name = account.getAccountName().getText();
        Assert.assertEquals(name, "Siva Kumar");
        account.getLogout();
        home.profileIcon();
        login.getCreateAccountLink().click();
        Caccount.createAccount("", "", "", "");
        String promtmessgae= account.ErrorMessage();
        Assert.assertEquals(promtmessgae, "Please adjust the following:");
    }

    @Test
    public void ProductSearchnadFiltering() throws InterruptedException, IOException, ParseException {


        search.Search(data.fetchData("productName"));
        wait.until(ExpectedConditions.elementToBeClickable(search.getProducttype()));
        search.getProducttype().click();
        wait.until(ExpectedConditions.elementToBeClickable(search.getSelect1producttype()));
        search.getSelect1producttype().click();
        scroll.clickOutOff();
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
        WebElement Productelements = home.Secondproduct();
        wait.until(ExpectedConditions.visibilityOf(Productelements));
        Productelements.click();
        WebElement element=pd.SoldOrCart();
        String soldoutElement = element.getText();
        if (soldoutElement.contains("Sold out")) {
            System.out.println("This product is Sold out");
        } else {
            element.click();
            wait.until(ExpectedConditions.visibilityOf(addtocartpopup.getSuccessmessage()));
            Assert.assertEquals(addtocartpopup.getSuccessmessage().getText(), "Item added to your cart");
            Assert.assertEquals(addtocartpopup.getcartnotification().getText(), "View my cart (1)");
            addtocartpopup.countinueShopping();
            home.addCartIcon();

            cart.countinueShopping();
            home.Thirdproduct().click();
            pd.addToCart();
            wait.until(ExpectedConditions.visibilityOf(addtocartpopup.getSuccessmessage()));
            addtocartpopup.ViewMyCart();
            List<WebElement> ActualAmount= cart.getActualPrices();
            double actnu = 0;
            for (WebElement price : ActualAmount) {

                String Actualprice = price.getText();
                String[] act = Actualprice.split(" ");
                actnu += Double.parseDouble(act[1]);
            }
            String ExpAmount=cart.getExpectPrice().getText();
            String DiscountAmount=cart.getDiscountPrice().getText();

            String[] exp = ExpAmount.split(" ");
            double expnu = Double.parseDouble(exp[1]);
            double dis = actnu - expnu;
            String discountprice = String.valueOf(dis);
            Assert.assertTrue(DiscountAmount.contains(discountprice));
            WebElement checkoutButton=cart.getCheckoutButton();
            scroll.scrollIntoView(checkoutButton);
            wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            checkoutButton.click();

            String Emailid = data.fetchData("emailId");
            String Password = data.fetchData("password");
            try {
                LogHelper.logInfo("Entering the method LoggingMechanism.");
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
        scroll.scrollIntoView(account.updateButton());
        Assert.assertEquals(Firstname + " " + Lastname, account.getupdatedetails().contains(Firstname + " " + Lastname));
    }

    @Test
    public void OutofStockProducts() throws InterruptedException {
        home.FirstProduct();
        WebElement element = pd.SoldOrCart();
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
        String Emailid = data.fetchData("emailId");
        reset.emailId(Emailid);
        reset.submitButton();
        String errormessage = login.getErrorMessage().getText();
        Assert.assertTrue(errormessage.contains("We've sent you an email with a link to update your password"));
    }

    @Test
    public void OrderHistoryandDetailsAccuracy() throws IOException, ParseException, InterruptedException {
        home.profileIcon();
        String Emailid = data.fetchData("emailId");
        String Password = data.fetchData("password");
        login.LoginAccount(Emailid,Password);
        Assert.assertTrue(account.getTitile().isDisplayed());
        String orderId = account.getOrderIdElement().getText();
        String Totalprice = account.getTotalPrice();
        String DataandTime = account.getDataandTime();
        wait.until(ExpectedConditions.elementToBeClickable(account.getOrderIdElement()));
        account.getOrderIdElement().click();
        String OrderDetailsId=account.getOrderDetailsIdElement().getText();
        wait.until(ExpectedConditions.visibilityOf(account.getOrderDetailsIdElement()));
        Assert.assertTrue(OrderDetailsId.contains(orderId));
        Assert.assertEquals(Totalprice,account.getDeatialsTotalPrice());
        Assert.assertTrue(account.getDetailsDataandTime().contains(DataandTime));
    }

    @Test
    public void SearchFunctionalitywithSpecialCharacters() throws IOException, ParseException, InterruptedException {//    %$^%$^$%QW$

        search.Search(data.fetchData("specialCharacterPname"));
        Assert.assertTrue(search.getErrorMessage().isDisplayed());
    }
}
