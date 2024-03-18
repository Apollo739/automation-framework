import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {

    private WebDriver driver = null;
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    @BeforeMethod
    @Parameters("baseUrl")
    public void createDriver(String baseUrl) throws MalformedURLException {
        driver = pickDriver(System.getProperty("browserName"));
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

    public WebDriver pickDriver(String browserName) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridUrl = "http://192.168.123.175:4444";
        switch (browserName) {
            case "chrome": //browserNam=chrome
                WebDriverManager.chromedriver().clearDriverCache().setup();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
            case "safari": //browserNam=safari
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "fireFox": //browserNam=fireFox
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                return driver = new FirefoxDriver();
            case "remoteDriver":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
            default:
                WebDriverManager.chromedriver().clearDriverCache().setup();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }

    }
}
