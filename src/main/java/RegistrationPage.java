import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
    By signUpFormLocator = By.cssSelector("#sign-up");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpFormDisplayed() {
        WebElement signUpForm = waitAndFindWebElement(signUpFormLocator);
        return signUpForm.isDisplayed();
    }
}
