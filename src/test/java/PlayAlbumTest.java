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
        login("blacklion739@gmail.com", "");
        WebElement nowPlayingMenuItem = driver.findElement(By.xpath("//a[text()='My Stations']"));
        nowPlayingMenuItem.click();
        WebElement cleanAlbum = driver.findElement(By.xpath(" //div[contains(text(), 'Clean')]"));
        cleanAlbum.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#player_main_row")));
        WebElement playerMusicWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#player_main_row")));
        Assert.assertTrue(playerMusicWidget.isDisplayed());
    }
}
