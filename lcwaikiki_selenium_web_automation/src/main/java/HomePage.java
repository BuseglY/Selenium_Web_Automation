import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    SearchBox searchBox;

    By fastDeliveryOptionLocator=new By.ByCssSelector("div.icon-delivery");

    By cartContainerLocator=new By.ByCssSelector("a.header-cart");
    By acceptCookiesLocator=new By.ByCssSelector("p.cookie__button");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnHomePage(){
        return isVisibility(fastDeliveryOptionLocator);
    }

    public SearchBox searchBox() {
        searchBox=new SearchBox(driver);
        return this.searchBox;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    public void acceptCookies(){
        if(isVisibility(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }

    }
}
