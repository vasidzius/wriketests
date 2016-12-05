package com.vasidzius.wriketests.pageobjects.workspace;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Блок глобальной навигации")
@FindBy(css = "#global-navigation-panel")
public class NavPanel extends HtmlElement {

    @FindBy(css = "#folder-tab")
    public Button rootFolder;

    @FindBy(css = "#inbox-tab")
    public Button inboxMessages;

    @FindBy(css = "#dashboard")
    public Button dashboard;

}
