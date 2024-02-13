import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

import java.time.Duration;

public class MainPageTest extends BaseTest {

    @Test
    public void loginTest() {
        login("blacklion739@gmail.com", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='Log In']")));
        WebElement exploreStation = driver.findElement(By.cssSelector("#explore-stations"));
        WebElement menuButton = driver.findElement(By.cssSelector("#menu-user"));
        menuButton.click();
        WebElement viewProfile = driver.findElement(By.xpath("//li[text()='View Profile']"));
        viewProfile.click();
        WebElement imageProfile = driver.findElement(By.cssSelector(".main-image"));
        Assert.assertTrue(imageProfile.isDisplayed());
    }

    @Test
    public void signUpTest() {
        WebElement signUpButton = driver.findElement(By.xpath("//a[text()='Sign Up']"));
        signUpButton.click();
        WebElement signUpForm = driver.findElement(By.cssSelector("#sign-up"));
        Assert.assertTrue(signUpForm.isDisplayed());

    }

    @Test(testName = "Check login function", dataProvider = "provideIncorrectCredentials", dataProviderClass = CredentialsProvider.class)
    public void loginWithIncorrectCredentials(String email, String password) {
        login(email, password);
        WebElement alert = driver.findElement(By.cssSelector("[role='alert']"));
        Assert.assertTrue(alert.isDisplayed());
    }
}
