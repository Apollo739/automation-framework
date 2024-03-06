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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("blacklion739@gmail.com", "sirius739");
        HomePage homePage = new HomePage(driver);
        homePage.clickToMyStationMenuItem();
        MyStationPage myStationPage = new MyStationPage(driver);
        myStationPage.clickNowPlaying();
        NowPlaying nowPlaying = new NowPlaying(driver);
        Assert.assertTrue(nowPlaying.isNowPlayingDisplaying());
    }
}
