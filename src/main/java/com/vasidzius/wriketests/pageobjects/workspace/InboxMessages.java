package com.vasidzius.wriketests.pageobjects.workspace;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(css = "ws-inbox")
public class InboxMessages extends HtmlElement {

    @FindBy(css = ".notification-list-zero-state")
    public TextBlock text;
}
