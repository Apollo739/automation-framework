import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

public class MainPageTest extends BaseTest {

    @Test
    public void loginTest() {
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Log In']"));
        loginButton.click();
        WebElement loginForm = driver.findElement(By.cssSelector("#log-in"));
        Assert.assertTrue( loginForm.isDisplayed());

    }

    @Test
    public void signUpTest() {
        WebElement signUpButton = driver.findElement(By.xpath("//a[text()='Sign Up']"));
        signUpButton.click();
        WebElement signUpForm = driver.findElement(By.cssSelector("#sign-up"));
        Assert.assertTrue(signUpForm.isDisplayed());

    }
}


