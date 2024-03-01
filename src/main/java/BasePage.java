import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver pageDriver = null;
    WebDriverWait wait = null;
    By alertLocator = By.cssSelector("[role='alert']");
    By myStationMenuItemLocator = By.xpath("//a[text()='My Stations']");

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;
        wait = new WebDriverWait(pageDriver, Duration.ofSeconds(3));
    }

    public WebElement waitAndFindWebElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementDisappeared(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean isAlertDisplayed() {
        WebElement alert = waitAndFindWebElement(alertLocator);
        return alert.isDisplayed();
    }

    public void clickToMyStationMenuItem() {
        WebElement myStationMenuItem = waitAndFindWebElement(myStationMenuItemLocator);
        myStationMenuItem.click();
    }
}
