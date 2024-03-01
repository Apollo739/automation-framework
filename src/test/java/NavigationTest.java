import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigationTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("blacklion739@gmail.com", "sirius739");
        HomePage homePage = new HomePage(driver);
        homePage.clickToMyStationMenuItem();
        MyStationPage myStationPage = new MyStationPage(driver);
        Assert.assertTrue(myStationPage.isMyStationDisplayed());
    }
}
