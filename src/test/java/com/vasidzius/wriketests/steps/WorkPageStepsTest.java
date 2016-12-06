package com.vasidzius.wriketests.steps;

import com.vasidzius.wriketests.retrofit2.RetrofitTestUtils;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.io.IOException;

import static org.junit.Assert.*;

public class WorkPageStepsTest extends BasePageSteps {

    private WorkPageSteps workPageSteps = injector.getInstance(WorkPageSteps.class);

    @Description("Отрыть страницу Workspace")
    @Test
    public void testOpen(){
        authWithDefaultUser();
        assertTrue(workPageSteps.isOpened());
    }

    @Description("Создать задачу через UI, проверить ее существование с помощью" +
            "Retrofit и удалить эту задачу с помощью Retrofit")
    @Test
    public void testCreateDeleteTask() throws IOException, InterruptedException {
        authWithDefaultUser();
        workPageSteps.openRootFolder();
        String name = "Some Task from " + System.getProperty("currentBrowser");
        workPageSteps.createNewTask(name);
        Thread.sleep(2000);
        RetrofitTestUtils.customAssert(wrikeService.getTask(name).execute());
        RetrofitTestUtils.deleteTaskByName(wrikeService, name);
    }

    @Description("'Теперь тут порядок!' тест")
    @Test
    public void testOpenInboxMessages(){
        authWithDefaultUser();
        workPageSteps.openInboxMessagesFolder();
        assertTrue(workPageSteps.inboxMessagesIsOpened());
    }



}