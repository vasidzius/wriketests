package com.vasidzius.wriketests.steps;

import com.google.inject.Inject;
import com.vasidzius.wriketests.pageobjects.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageSteps {

    private LoginPage loginPage;

    @Inject
    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Step("Открыть страницу логина")
    void open() {
        loginPage.getDriver().get("https://www.wrike.com/login/");
    }

    @Step("Страница логина открыта")
    boolean isOpened() {
        return loginPage.enterButton.isDisplayed();
    }

    @Step("Аутентификация")
    void login(String login, String password){
        loginPage.emailField.sendKeys(login);
        loginPage.passwordField.sendKeys(password);
        loginPage.enterButton.click();

    }
}
