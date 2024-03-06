import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[text()='Log In']")
    WebElement loginButtonLocator;
    @FindBy(css = "[name='email']")
    WebElement emailInputLocator;
    @FindBy(css = "[name='password']")
    WebElement passwordInputLocator;
    @FindBy(css = "button[type='submit']")
    WebElement submitLoginButton;
    @FindBy(xpath = "//a[text()='Log In']")
    WebElement loginFormLocator;
    @FindBy(xpath = "//a[text()='Sign Up']")
    WebElement signUpButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        loginButtonLocator.click();
        emailInputLocator.sendKeys(email);
        passwordInputLocator.sendKeys(password);
        submitLoginButton.click();
    }

    public void waitUntilLoginFormDisappeared() {
        waitUntilElementDisappeared(loginFormLocator);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
