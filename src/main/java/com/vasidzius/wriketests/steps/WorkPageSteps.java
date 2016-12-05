package com.vasidzius.wriketests.steps;

import com.google.inject.Inject;
import com.vasidzius.wriketests.pageobjects.workspace.WorkSpacePage;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

class WorkPageSteps {

    @Inject
    private WorkSpacePage workSpacePage;

    @Inject
    private LoginPageSteps loginPageSteps;

    @Step("Страница WorkSpace открыта")
    boolean isOpened() {
        return workSpacePage.wspaceLogo.isDisplayed();
    }

    @Step("Открыть корневую папку")
    void openRootFolder() {
        workSpacePage.navPanel.rootFolder.click();
    }

    @Step("Открыть вкладку 'Входящие'")
    void openInboxMessagesFolder() {
        workSpacePage.navPanel.inboxMessages.click();
    }

    @Step("Папка 'Входящие' открыта")
    boolean inboxMessagesIsOpened() {
        return ("Теперь тут порядок!".equals(workSpacePage.inboxMessages.text.getText()));
    }

    @Step("Создать новую задачу в корневой папке")
    void createNewTask(String name) {
        workSpacePage.navPanel.rootFolder.click();
        workSpacePage.rootFolder.newTask.click();
        workSpacePage.rootFolder.newTaskNameInput.sendKeys(name, Keys.ENTER);
    }
}
