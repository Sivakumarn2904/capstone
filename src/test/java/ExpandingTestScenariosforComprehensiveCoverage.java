import GenericUtils.Baseclass;
import POMPages.CreateAccount;
import POMPages.HomePage;
import POMPages.SearchContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.SortedMap;

public class ExpandingTestScenariosforComprehensiveCoverage extends Baseclass {
    CreateAccount account;
    HomePage home;
    Random random;
    SearchContext search;
    @Test
    public void verifyUserRegistration() throws InterruptedException {

         home=new HomePage(driver);
         account = new CreateAccount(driver);
        home.profileIcon();
         random = new Random();
        int numbers = random.nextInt(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Create account')]")).click();
        account.createAccount("Siva","Kumar","siva"+numbers+"@gmail.com","Sivakumar");
        home.profileIcon();
        String name = driver.findElement(By.xpath("//p[text()='Siva Kumar']")).getText();
        Assert.assertEquals(name,"Siva Kumar");
        driver.findElement(By.xpath("//h1[text()='Account']/following-sibling::a")).click();
        account = new CreateAccount(driver);
        home.profileIcon();
        int numbers1 = random.nextInt(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Create account')]")).click();
        account.createAccount("","","","");
        String promtmessgae = driver.findElement(By.xpath("//form[@id='create_customer']/input/following-sibling::h2")).getText();
        Assert.assertEquals(promtmessgae,"Please adjust the following:");
    }

    @Test
    public void ProductSearchandFiltering() throws InterruptedException {

        search= new SearchContext(driver);
        search.Search("Bags");
        ((JavascriptExecutor) driver).executeScript("document.body.click();");
        String PName = search.SearchText();
        int number=0;
        for (int i=0;i<PName.length();i++){
            if(PName.charAt(i)>='0' && PName.charAt(i)<='9'){
                number+=Integer.parseInt(PName.charAt(i)+"");
            }
        }
        int pCount = search.ProductCount();
        Assert.assertEquals(number,pCount);
    }
}
