import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By seeMoreProductsButtonLocator= new By.ByCssSelector("p.lazy-load-text");
    By productInfoLocator= new By.ByCssSelector("a.a_model_item");
    By productPriceOnHomePageLocator=new By.ByCssSelector("div.basket-discount");

    public int i;
    public String price;
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isVisibility(seeMoreProductsButtonLocator);
    }

    public void hitTheSeeMoreProductsButton(){
        click(seeMoreProductsButtonLocator);
    }

    public void selectProduct(int i) {
        price=getAllProductPrices().get(i).getText();
        getAllProducts().get(i).click();
    }
    private List<WebElement> getAllProducts(){
        return findAll(productInfoLocator);
    }

    private List<WebElement> getAllProductPrices(){
        return findAll(productPriceOnHomePageLocator);
    }

    public String compareProductsPage(){
        return price;
    }
}
