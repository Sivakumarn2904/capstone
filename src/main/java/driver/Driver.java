package driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }


    public static WebDriver initDriver(String browser, String version) {


        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser, version));

            } catch (MalformedURLException e) {
                throw new RuntimeException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get("https://web-playground.ultralesson.com/");
            return DriverManager.getDriver();
        }
        return null;
    }


    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
