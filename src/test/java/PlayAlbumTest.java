import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlayAlbumTest extends BaseTest {

    @Test
    public void playAlbumTest() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("blacklion739@gmail.com", "");
        HomePage homePage = new HomePage(getWebDriver());
        homePage.clickToMyStationMenuItem();
        MyStationPage myStationPage = new MyStationPage(getWebDriver());
        myStationPage.clickNowPlaying();
        NowPlaying nowPlaying = new NowPlaying(getWebDriver());
        Assert.assertTrue(nowPlaying.isNowPlayingDisplaying());
    }
}
