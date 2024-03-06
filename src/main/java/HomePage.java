import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css ="#explore-stations")
    WebElement exploreStationLocator;
    @FindBy(css = "#menu-user")
    WebElement menuButtonLocator;
    @FindBy(xpath = "//li[text()='View Profile']")
    WebElement viewProfileLocator;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openUserProfile() {
        menuButtonLocator.click();
        viewProfileLocator.click();

    }
}
