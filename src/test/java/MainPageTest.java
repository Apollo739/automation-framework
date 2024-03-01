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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("blacklion739@gmail.com", "");
        loginPage.waitUntilLoginFormDisappeared();
        HomePage homePage = new HomePage(driver);
        homePage.openUserProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isImageProfileDisplayed());
    }

    @Test
    public void signUpTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Assert.assertTrue(registrationPage.isSignUpFormDisplayed());
    }

    @Test(testName = "Check login function", dataProvider = "provideIncorrectCredentials", dataProviderClass = CredentialsProvider.class)
    public void loginWithIncorrectCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isAlertDisplayed());
    }
}
