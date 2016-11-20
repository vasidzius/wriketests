import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.GuiceModule;
import org.junit.After;
import org.openqa.selenium.WebDriver;

class BaseTest {

    Injector injector = Guice.createInjector(new GuiceModule());
//    private WebDriver driver = injector.getInstance(WebDriver.class);

//    @After
//    public void killDriver(){
//        driver.close();
//    }
}
