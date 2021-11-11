import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator= By.id("pd_add_to_cart");
    By chooseSizeForCartLocator= By.xpath("//a[contains(@size,\" \")][1]");
    By productPriceOnProductDetailPageLocator=By.cssSelector("div.basket-discount");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isVisibility(addToCartButtonLocator);
    }

    public void addToCart() {
        click(chooseSizeForCartLocator);
        click(addToCartButtonLocator);
    }

    private List<WebElement> getAllProductPricesOnProductDetail(){
        return findAll(productPriceOnProductDetailPageLocator);
    }

    public String compareProductDetailPage(){
        return getAllProductPricesOnProductDetail().get(1).getText();
    }


}
