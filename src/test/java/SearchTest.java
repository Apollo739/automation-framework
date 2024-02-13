import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String songName = "Zach Bryan";
        login("blacklion739@gmail.com", "");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#log-in")));
        WebElement searchSongInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".searchbar input")));
        searchSongInput.sendKeys(songName);
        WebElement searchResult = driver.findElement(By.xpath(String.format("//h3[contains(text(), '%s')]", songName)));
        Assert.assertTrue(searchResult.isDisplayed());
    }
}
