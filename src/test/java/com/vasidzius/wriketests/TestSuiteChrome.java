package com.vasidzius.wriketests;

import com.vasidzius.wriketests.steps.LoginPageStepsTest;
import com.vasidzius.wriketests.steps.WorkPageStepsTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.yandex.qatools.allure.annotations.Parameter;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginPageStepsTest.class,
        WorkPageStepsTest.class
})
public class TestSuiteChrome {
    @Parameter
    private static String currentBrowser = "Chrome";

    @BeforeClass
    public static void before(){
        System.setProperty("currentBrowser", currentBrowser);
    }
}
