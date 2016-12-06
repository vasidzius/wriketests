package com.vasidzius.wriketests;

import com.vasidzius.wriketests.steps.LoginPageStepsTest;
import com.vasidzius.wriketests.steps.WorkPageStepsTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginPageStepsTest.class,
        WorkPageStepsTest.class
})
public class TestSuiteFirefox {

    @SuppressWarnings("FieldCanBeLocal")
    private static String currentBrowser = "Firefox";

    @BeforeClass
    public static void before(){
        System.setProperty("currentBrowser", currentBrowser);
    }
}
