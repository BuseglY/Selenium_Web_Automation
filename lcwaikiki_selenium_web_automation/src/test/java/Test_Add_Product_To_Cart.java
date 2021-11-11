import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void check_the_login(){
        homePage=new HomePage(driver);
        homePage.acceptCookies();
        loginPage=new LoginPage(driver);
        loginPage.login("busegly@outlook.com","testiniumproject.123");
        Assertions.assertTrue(homePage.isOnHomePage(),"Not on home page!");
    }

    @Test
    @Order(2)
    public void search_a_product(){
        productsPage=new ProductsPage(driver);
        homePage.searchBox().search("pantolan");
        Assertions.assertTrue(productsPage.isOnProductPage(), "Not on products page!");
    }

    @Test
    @Order(3)
    public void select_a_product(){
        productDetailPage=new ProductDetailPage(driver);
        productsPage.hitTheSeeMoreProductsButton();
        productsPage.selectProduct(9);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"Not on product detail page!");
    }

    @Test
    @Order(4)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        String productPriceOnHomePage=productsPage.compareProductsPage();
        String productPriceOnProductDetailPage=productDetailPage.compareProductDetailPage();
        Assertions.assertEquals(productPriceOnHomePage,productPriceOnProductDetailPage,"The price on the product page is not the same as the price on the cart.");

    }

    @Test
    @Order(5)
    public void go_to_cart(){
        cartPage=new CartPage(driver);
        homePage.goToCart();
        cartPage.increaseTheProduct();
        cartPage.isProductCountUp();
    }

    @Test
    @Order(6)
    public void delete_the_product(){
        cartPage.deleteToProduct();
        Assertions.assertTrue(cartPage.emptyCart(),"Cart is not empty");
    }
}
