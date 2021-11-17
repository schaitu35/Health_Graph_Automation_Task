package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.PropReader;

import java.util.Properties;

public class AppHooks {

    private final DriverFactory driverFactory = new DriverFactory();
    private final PropReader reader = new PropReader();
    private WebDriver driver;
    Properties props;


    @Before
    public void launchBrowser() {
        props = reader.initProps();
        String browser = props.getProperty("browser");
        driver = driverFactory.initDiver(browser);
        driver.get(props.getProperty("url"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
