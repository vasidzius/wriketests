package guice;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WebDriver.class).toInstance(new FirefoxDriver());

//        File file = new File("C:\\Users\\Vkov\\Downloads\\wriketests\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        bind(WebDriver.class).toInstance(new ChromeDriver());
    }
}
