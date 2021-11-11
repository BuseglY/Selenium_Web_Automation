import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    By plusLocator= new By.ByCssSelector("a.oq-up");
    By deleteLocator=By.xpath("//a[contains(@id,'Cart_ProductDelete')]//i");
    //By deleteLocator =By.xpath("");
    By deleteButtonLocator=new By.ByCssSelector("a.inverted-modal-button");
    By cartCountLocator=new By.ByCssSelector("span.spanCart");
    By emptyCartLocator=new By.ByCssSelector("p.cart-empty-title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void increaseTheProduct(){
        click(plusLocator);
    }

    public void deleteToProduct(){
        click(deleteLocator);
        click(deleteButtonLocator);
    }

    public boolean isProductCountUp() {
        int count=Integer.parseInt(find(cartCountLocator).getText());
        return count==2;
    }

    public boolean emptyCart(){
        return isVisibility(emptyCartLocator);
    }
}
