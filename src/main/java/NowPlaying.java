import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NowPlaying extends BasePage {
    By playerMusicWidgetLocator = By.cssSelector("#player_main_row");
    public boolean isNowPlayingDisplaying(){
        WebElement playerMusic = waitAndFindWebElement(playerMusicWidgetLocator);
        return playerMusic.isDisplayed();
    }
    public NowPlaying(WebDriver driver) {
        super(driver);
    }
}
