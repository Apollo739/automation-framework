import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigationTest() {
        login("blacklion739@gmail.com", "");
        WebElement nowPlayingMenuItem = driver.findElement(By.xpath("//a[text()='My Stations']"));
        nowPlayingMenuItem.click();
        WebElement myStations = driver.findElement(By.cssSelector("#my-stations"));
        Assert.assertTrue(myStations.isDisplayed());
    }
}
