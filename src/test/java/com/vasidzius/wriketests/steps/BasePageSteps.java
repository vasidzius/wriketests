package com.vasidzius.wriketests.steps;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vasidzius.wriketests.guice.GuiceModule;
import com.vasidzius.wriketests.retrofit2.CustomRetrofit;
import com.vasidzius.wriketests.retrofit2.WrikeService;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.PasswordAuthentication;

@SuppressWarnings("WeakerAccess")
public class BasePageSteps {

    Injector injector = Guice.createInjector(new GuiceModule());

    private WebDriver driver = injector.getInstance(WebDriver.class);

    private PasswordAuthentication auth = injector.getInstance(PasswordAuthentication.class);

    LoginPageSteps loginPageSteps = injector.getInstance(LoginPageSteps.class);

    WrikeService wrikeService = new CustomRetrofit().getService();

    @SuppressWarnings("unused")
    @Parameter
    private String currentBrowser = System.getProperty("currentBrowser");

    @Rule
    public TestWatcher screenShotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenShot();
        }
    };

    @After
    public void killDriver() throws InterruptedException {
        driver.close();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    @Step("Скриншот сломанного теста")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Step("Пройти аутентификацию с дефолтовым юзером")
    void authWithDefaultUser() {
        loginPageSteps.open();
        loginPageSteps.login(
                auth.getUserName(),
                auth.getPassword()
        );
    }
}
