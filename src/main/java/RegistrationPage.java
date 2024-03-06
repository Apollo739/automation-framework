import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(css = "#sign-up" )
    WebElement signUpFormLocator;
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpFormDisplayed() {
        return signUpFormLocator.isDisplayed();
    }
}
