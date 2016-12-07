package com.vasidzius.wriketests;

import com.vasidzius.wriketests.logic.LoginPageStepsTest;
import com.vasidzius.wriketests.logic.WorkPageStepsTest;
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
    private static final String currentBrowser = "Firefox";

    @BeforeClass
    public static void before(){
        System.setProperty("currentBrowser", currentBrowser);
    }
}
