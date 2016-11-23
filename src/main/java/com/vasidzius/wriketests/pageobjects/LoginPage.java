package com.vasidzius.wriketests.pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class LoginPage extends BasePage {

    @Inject
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id='submit-login-button']")
    public Button enterButton;
}
