package GenericUtils;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

   protected WebDriver driver;
    private static DriverFactory instance;

    DriverFactory() {
        // private constructor to prevent instantiation
    }

    public static synchronized DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver createDriver(String browser) {
        // logic to initialize WebDriver based on the browser parameter

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;

            default:
                System.out.println("Please enter the browser");
                break;
        }
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is null. Check browser configuration.");
        }

        return driver;
    }
    public WebDriver closeDriver() {
        driver.quit();
        return driver;
    }
//    public void selectBrowser(String browser) {
//        switch (browser) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                driver = new InternetExplorerDriver();
//                break;
//
//            default:
//                System.out.println("Please enter the browser");
//                break;
//        }
//
//    }
}
