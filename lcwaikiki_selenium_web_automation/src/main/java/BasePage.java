import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BasePage {
    WebDriver driver;
    String baseUrl="https://www.lcwaikiki.com/tr-TR/TR/";

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void clear(By locator){
        find(locator).clear();
    }

    public void send(By locator, String text){
        find(locator).sendKeys(text);
    }

    public Boolean isVisibility(By locator){
        return find(locator).isDisplayed();
    }
}
