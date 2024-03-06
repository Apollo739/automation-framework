import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NowPlaying extends BasePage {
    @FindBy(css = "#player_main_row")
    WebElement playerMusicWidgetLocator;
    public boolean isNowPlayingDisplaying(){
        return playerMusicWidgetLocator.isDisplayed();
    }
    public NowPlaying(WebDriver driver) {
        super(driver);
    }
}
