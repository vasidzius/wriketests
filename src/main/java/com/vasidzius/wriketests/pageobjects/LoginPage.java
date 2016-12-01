package com.vasidzius.wriketests.pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends BasePage {

    @Inject
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id='submit-login-button']")
    public Button enterButton;

    @FindBy(xpath = ".//*[@id='emailField']")
    public TextInput emailField;

    @FindBy(xpath = ".//*[@id='passwordField']")
    public TextInput passwordField;
}
