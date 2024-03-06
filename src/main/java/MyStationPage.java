import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStationPage extends BasePage {
    @FindBy  (css= "#my-stations")


    WebElement myStationsLocator;
    public MyStationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyStationDisplayed() {
        return  myStationsLocator.isDisplayed();
    }
}
