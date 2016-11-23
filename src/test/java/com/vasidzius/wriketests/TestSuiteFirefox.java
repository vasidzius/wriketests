package com.vasidzius.wriketests;

import com.vasidzius.wriketests.steps.LoginPageStepsTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.yandex.qatools.allure.annotations.Parameter;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginPageStepsTest.class
})
public class TestSuiteFirefox {

    @SuppressWarnings("FieldCanBeLocal")
    @Parameter
    private static String currentBrowser = "Firefox";

    @BeforeClass
    public static void before(){
        System.setProperty("currentBrowser", currentBrowser);
    }
}
