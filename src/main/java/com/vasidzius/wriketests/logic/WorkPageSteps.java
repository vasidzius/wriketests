package com.vasidzius.wriketests.logic;

import com.google.inject.Inject;
import com.vasidzius.wriketests.pageobjects.workspace.WorkSpacePage;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.allure.annotations.Step;

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
    boolean inboxMessagesIsOpened() throws InterruptedException {
        Thread.sleep(2000);
        String text = workSpacePage.inboxMessages.text.getText();
        return ("Теперь тут порядок!".equals(text));
    }

    @Step("Создать новую задачу в корневой папке")
    void createNewTask(String name) {
        workSpacePage.navPanel.rootFolder.click();
        workSpacePage.rootFolder.newTask.click();
        workSpacePage.rootFolder.newTaskNameInput.sendKeys(name, Keys.ENTER);
    }
}
