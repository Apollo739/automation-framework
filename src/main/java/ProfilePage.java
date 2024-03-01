import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    By imageProfileLocator = By.cssSelector(".main-image");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isImageProfileDisplayed() {
        return waitAndFindWebElement(imageProfileLocator).isDisplayed();
    }
}
