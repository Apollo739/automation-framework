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
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("blacklion739@gmail.com", "");
        loginPage.waitUntilLoginFormDisappeared();
        HomePage homePage = new HomePage(getWebDriver());
        homePage.openUserProfile();
        ProfilePage profilePage = new ProfilePage(getWebDriver());
        Assert.assertTrue(profilePage.isImageProfileDisplayed());
    }

    @Test
    public void signUpTest() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.clickSignUpButton();
        RegistrationPage registrationPage = new RegistrationPage(getWebDriver());
        Assert.assertTrue(registrationPage.isSignUpFormDisplayed());
    }

    @Test(testName = "Check login function", dataProvider = "provideIncorrectCredentials", dataProviderClass = CredentialsProvider.class)
    public void loginWithIncorrectCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isAlertDisplayed());
    }
}
