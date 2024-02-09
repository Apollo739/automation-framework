import org.testng.annotations.DataProvider;

public class CredentialsProvider {

    @DataProvider(name = "provideIncorrectCredentials")
    public Object[][] incorrectCredentialsProvider() {
        return new Object[][] {
                {"test@gmail.com", "testets"},
                {"", "testets"},
                {"test@gmail.com", ""},
                {"", ""}
        };
    }
}
