package com.vasidzius.wriketests.pageobjects.workspace;

import com.google.inject.Inject;
import com.vasidzius.wriketests.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class WorkSpacePage extends BasePage {

    @Inject
    public WorkSpacePage(WebDriver driver){
        super(driver);
    }

    public NavPanel navPanel;

    public InboxMessages inboxMessages;

    public RootFolder rootFolder;

    @FindBy(css = ".wspace_header_logo")
    public WebElement wspaceLogo;

}
