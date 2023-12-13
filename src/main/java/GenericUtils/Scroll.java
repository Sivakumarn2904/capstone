package GenericUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scroll extends DriverFactory{

    public void clickOutOff(){
        ((JavascriptExecutor)driver).executeScript("document.body.click();");
    }
    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
