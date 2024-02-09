import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

public class MainPageTest extends BaseTest {

    @Test
    public void loginTest() {
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Log In']"));
        loginButton.click();
        WebElement emailInput = driver.findElement(By.cssSelector("[name='email']"));
        emailInput.sendKeys("blacklion739@gmail.com");
        WebElement passwordInput = driver.findElement(By.cssSelector("[name='password']"));
        passwordInput.sendKeys("");
        WebElement  submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();
        WebElement exploreStation = driver.findElement(By.cssSelector("#explore-stations"));
        Assert.assertTrue(exploreStation.isDisplayed());

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
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Log In']"));
        loginButton.click();
        WebElement emailInput = driver.findElement(By.cssSelector("[name='email']"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.cssSelector("[name='password']"));
        passwordInput.sendKeys(password);
        WebElement  submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();
        WebElement alert = driver.findElement(By.cssSelector("[role='alert']"));
        Assert.assertTrue(alert.isDisplayed());
    }

}


