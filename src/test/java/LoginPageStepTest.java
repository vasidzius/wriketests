import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.LoginPageStep;

import static org.junit.Assert.assertTrue;

public class LoginPageStepTest extends BaseTest {

    private LoginPageStep loginPageStep = injector.getInstance(LoginPageStep.class);
    private WebDriver driver = injector.getInstance(WebDriver.class);

    @Test
    public void testOpenLoginPage() {
        loginPageStep.open();
        assertTrue(loginPageStep.isOpened());
        driver.close();
    }



}
