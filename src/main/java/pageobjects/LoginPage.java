package pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLElement;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = ".//*[@id='submit-login-button']")
    public Button enterButton;

    WebDriver driver;

    @Inject
    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
