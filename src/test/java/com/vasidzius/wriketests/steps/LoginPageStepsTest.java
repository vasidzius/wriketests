package com.vasidzius.wriketests.steps;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;

import static org.junit.Assert.assertTrue;

public class LoginPageStepsTest extends BasePageSteps {

    private WorkPageSteps workPageSteps = injector.getInstance(WorkPageSteps.class);

    @Description("Открыть страницу аутентификации")
    @Test
    public void testOpenLoginPage() {
        loginPageSteps.open();
        assertTrue(loginPageSteps.isOpened());
    }

    @Description("Зайти в рабочее пространство")
    @Test
    public void testAuthentication() throws InterruptedException {
        authWithDefaultUser();
        assertTrue(workPageSteps.isOpened());
    }

}
