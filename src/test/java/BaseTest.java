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

    private WebDriver driver = null;
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    @BeforeSuite
    public void  setupDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }

    @BeforeMethod
    @Parameters("baseUrl")
    public void createDriver(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        threadLocal.set(driver);
        threadLocal.get().get(baseUrl);
    }

    public WebDriver getWebDriver() {
        return threadLocal.get();
    }

    @AfterMethod
    public void closeDriver() {
        getWebDriver().close();
    }
}
