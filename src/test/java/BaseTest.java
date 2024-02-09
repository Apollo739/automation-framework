import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {

    WebDriver driver = null;

    @BeforeSuite
    public void  setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("baseUrl")
    public void createDriver(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

    public void login(String email, String password) {
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Log In']"));
        loginButton.click();
        WebElement emailInput = driver.findElement(By.cssSelector("[name='email']"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.cssSelector("[name='password']"));
        passwordInput.sendKeys(password);
        WebElement  submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();
    }

}
