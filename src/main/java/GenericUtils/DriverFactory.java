package GenericUtils;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
WebDriver driver;

    public void selectBrowser(String browser) {
        switch (browser) {
            case "chrome":
//                driver = new ChromeDriver();
                DriverManager.setDriver(new ChromeDriver());
                break;
            case "firefox":
//                driver = new FirefoxDriver();
                DriverManager.setDriver(new FirefoxDriver());
                break;
            case "edge":
//                driver = new InternetExplorerDriver();
                DriverManager.setDriver(new InternetExplorerDriver());
                break;

            default:
                System.out.println("Please enter the browser");
                break;
        }

    }
}
