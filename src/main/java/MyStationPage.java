import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStationPage extends BasePage {
    By cleanAlbumLocator = By.xpath(" //div[contains(text(), 'Clean')]");

    By myStationsLocator = By.cssSelector("#my-stations");
    public MyStationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyStationDisplayed() {
        WebElement myStation = waitAndFindWebElement(myStationsLocator);
        return myStation.isDisplayed();
    }
    public void clickToCleanAlbum() {
        WebElement cleanAlbum = waitAndFindWebElement(cleanAlbumLocator);
        cleanAlbum.click();
    }
}
