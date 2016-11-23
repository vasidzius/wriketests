package com.vasidzius.wriketests.guice;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        if (System.getProperty("currentBrowser") == null) {
            System.out.println("No property 'currentBrowser' exists");
            bind(WebDriver.class).toInstance(new FirefoxDriver());
        } else if (System.getProperty("currentBrowser").equals("Firefox")) {
            bind(WebDriver.class).toInstance(new FirefoxDriver());
        } else if (System.getProperty("currentBrowser").equals("Chrome")) {
            File file = new File(getClass().getResource("/chromedriver.exe").getFile());
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            bind(WebDriver.class).toInstance(new ChromeDriver());
        }
    }

//    @Provides
//    WebDriver getChromeDriver() {
//        File file = new File(getClass().getResource("chromedriver.exe").getFile());
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        return new ChromeDriver();
//
//    }


}
