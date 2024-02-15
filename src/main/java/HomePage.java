import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    By exploreStationLocator = By.cssSelector("#explore-stations");
    By menuButtonLocator = By.cssSelector("#menu-user");
    By viewProfileLocator = By.xpath("//li[text()='View Profile']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openUserProfile() {
        WebElement menuButton = waitAndFindWebElement(menuButtonLocator);
        menuButton.click();
        WebElement viewProfile = waitAndFindWebElement(viewProfileLocator);
        viewProfile.click();
    }
}
