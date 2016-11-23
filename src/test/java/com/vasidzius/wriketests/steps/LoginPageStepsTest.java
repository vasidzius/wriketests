package com.vasidzius.wriketests.steps;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginPageStepsTest extends BasePageSteps {

    private LoginPageSteps loginPageSteps = injector.getInstance(LoginPageSteps.class);

    @Test()
    public void testOpenLoginPage() {
        loginPageSteps.open();
        assertTrue(loginPageSteps.isOpened());
    }



}