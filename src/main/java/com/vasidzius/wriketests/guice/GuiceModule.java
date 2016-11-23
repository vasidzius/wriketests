package com.vasidzius.wriketests.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WebDriver.class).toInstance(new FirefoxDriver());
    }

//    @Provides
//    WebDriver getChromeDriver() {
//        File file = new File(getClass().getResource("chromedriver.exe").getFile());
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        return new ChromeDriver();
//
//    }


}
