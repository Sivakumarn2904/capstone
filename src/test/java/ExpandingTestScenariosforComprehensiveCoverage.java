import org.openqa.selenium.By;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class ExpandingTestScenariosforComprehensiveCoverage extends Baseclass{
    CreateAccount account;
    @Test
    public void verifyUserRegistration() throws InterruptedException {
        HomePage home=new HomePage(driver);
         account = new CreateAccount(driver);
        home.profileIcon();
        Random random = new Random();
        int numbers = random.nextInt(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Create account')]")).click();
        account.createAccount("Siva","Kumar","siva"+numbers+"@gmail.com","Sivakumar");
        home.profileIcon();
        String name = driver.findElement(By.xpath("//p[text()='Siva Kumar']")).getText();
        Assert.assertEquals(name,"Siva Kumar");
    }
}
