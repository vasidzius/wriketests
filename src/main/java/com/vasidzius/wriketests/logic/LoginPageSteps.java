package com.vasidzius.wriketests.logic;

import com.google.inject.Inject;
import com.vasidzius.wriketests.pageobjects.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

class LoginPageSteps {

    @Inject
    private LoginPage loginPage;

    @Step("Открыть страницу логина")
    void open() {
        loginPage.getDriver().get("https://www.wrike.com/login/");
    }

    @Step("Страница логина открыта")
    boolean isOpened() {
        return loginPage.enterButton.isDisplayed();
    }

    @Step("Аутентификация")
    void login(String login, char[] password){
        loginPage.emailField.sendKeys(login);
        loginPage.passwordField.sendKeys(String.valueOf(password));
        loginPage.enterButton.click();
    }

}
