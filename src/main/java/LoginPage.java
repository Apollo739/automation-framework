import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    By loginButtonLocator = By.xpath("//a[text()='Log In']");
    By emailInputLocator = By.cssSelector("[name='email']");
    By passwordInputLocator = By.cssSelector("[name='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");
    By loginFormLocator = By.xpath("//a[text()='Log In']");
    By sighUpButtonLocator = By.xpath("//a[text()='Sign Up']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        WebElement loginButton = waitAndFindWebElement(loginButtonLocator);
        loginButton.click();
        WebElement emailInput = waitAndFindWebElement(emailInputLocator);
        emailInput.sendKeys(email);
        WebElement passwordInput = waitAndFindWebElement(passwordInputLocator);
        passwordInput.sendKeys(password);
        WebElement  submitLoginButton = waitAndFindWebElement(submitButtonLocator);
        submitLoginButton.click();
    }

    public void waitUntilLoginFormDisappeared() {
        waitUntilElementDisappeared(loginFormLocator);
    }

    public void clickSignUpButton() {
        WebElement signUpButton = waitAndFindWebElement(sighUpButtonLocator);
        signUpButton.click();
    }
}
