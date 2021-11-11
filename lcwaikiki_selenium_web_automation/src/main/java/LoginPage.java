import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By emailLocator=By.id("LoginEmail");
    private final By passwordLocator=By.id("Password");
    private final By submitButtonLocator= By.id("loginLink");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl.concat("giris"));
    }

    public void login(String email, String password){
        send(emailLocator,email);
        send(passwordLocator,password);
        click(submitButtonLocator);
    }
}
