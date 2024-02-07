import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void loginTest() {
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Log In']"));
        loginButton.click();
        Assert.assertTrue(loginButton.isDisplayed());

    }

    @Test
    public void signUpTest() {
        WebElement signUpButton = driver.findElement(By.xpath("//a[text()='Sign Up']"));
        signUpButton.click();
        Assert.assertTrue(signUpButton.isDisplayed());

    }
}
