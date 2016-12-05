package com.vasidzius.wriketests.steps;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;

import static org.junit.Assert.*;

public class WorkPageStepsTest extends BasePageSteps {

    private WorkPageSteps workPageSteps = injector.getInstance(WorkPageSteps.class);

    @Description("Отрыть страницу Workspace")
    @Test
    public void testOpen(){
        authWithDefaultUser();
        assertTrue(workPageSteps.isOpened());
    }

    @Description("Создать задачу")
    @Test
    public void testCreateTask(){
        authWithDefaultUser();
        workPageSteps.openRootFolder();
        String name = "Новая задача из Selenium";
        workPageSteps.createNewTask(name);
        // TODO: 06.12.2016 add Retrofit checking of creating new task
        assertTrue(false);
    }

    @Description("'Теперь тут порядок!' тест")
    @Test
    public void testOpenInboxMessages(){
        authWithDefaultUser();
        workPageSteps.openInboxMessagesFolder();
        assertTrue(workPageSteps.inboxMessagesIsOpened());
    }



}