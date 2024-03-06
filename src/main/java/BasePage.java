import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver pageDriver = null;
    WebDriverWait wait = null;

    @FindBy(css = "[role='alert']")
    WebElement alertLocator;
    @FindBy(xpath = "//a[text()='My Stations']")
    WebElement myStationMenuItemLocator;
    @FindBy(xpath = "//a[text()='Now Playing']" )
    WebElement nowPlayinglocator;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;
        wait = new WebDriverWait(pageDriver, Duration.ofSeconds(5));
        PageFactory.initElements(pageDriver, this);
    }

    public WebElement waitAndFindWebElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementDisappeared(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilElementDisappeared(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public boolean isAlertDisplayed() {
        return alertLocator.isDisplayed();
    }

    public void clickToMyStationMenuItem() {
        waitUntilElementToBeClickable(myStationMenuItemLocator);
        myStationMenuItemLocator.click();
    }

    public void waitUntilElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void clickNowPlaying() {
        nowPlayinglocator.click();

    }

}