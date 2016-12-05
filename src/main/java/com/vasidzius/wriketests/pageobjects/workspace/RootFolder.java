package com.vasidzius.wriketests.pageobjects.workspace;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Корневая папка")
@FindBy(css = "#tasklist-panel")
public class RootFolder extends HtmlElement{

    @FindBy(xpath = ".//*[@id='wspace;lister;adder']")
    public Button newTask;

    @FindBy(xpath = ".//*[@id='wspace;lister;group=']//input")
    public TextInput newTaskNameInput;
}
