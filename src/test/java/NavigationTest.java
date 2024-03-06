import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigationTest() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("blacklion739@gmail.com", "");
        HomePage homePage = new HomePage(getWebDriver());
        homePage.clickToMyStationMenuItem();
        MyStationPage myStationPage = new MyStationPage(getWebDriver());
        Assert.assertTrue(myStationPage.isMyStationDisplayed());
    }
}
