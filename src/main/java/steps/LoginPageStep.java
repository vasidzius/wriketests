package steps;

import com.google.inject.Inject;
import pageobjects.LoginPage;

public class LoginPageStep {

    LoginPage loginPage;

    @Inject
    public LoginPageStep(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void open() {
        loginPage.getDriver().get("https://www.wrike.com/login/");
    }

    public boolean isOpened() {
        return loginPage.enterButton.isDisplayed();
    }
}
