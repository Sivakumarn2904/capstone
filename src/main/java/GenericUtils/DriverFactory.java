package GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
WebDriver driver;

    public WebDriver selectBrowser(String browser) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new InternetExplorerDriver();
                break;

            default:
                System.out.println("Please enter the browser");
                break;
        }
        return driver;
    }

    public WebDriver closeBrowser() {
        driver.quit();
        return driver;
    }

}
