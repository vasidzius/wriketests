package com.vasidzius.wriketests.steps;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vasidzius.wriketests.guice.GuiceModule;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

@SuppressWarnings("WeakerAccess")
public class BasePageSteps {

    Injector injector = Guice.createInjector(new GuiceModule());

    private WebDriver driver = injector.getInstance(WebDriver.class);

    @Rule
    public TestWatcher screenShotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenShot();
        }
    };

    @After
    public void killDriver() {
        driver.close();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    @Step("Make screen shot of results page")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
