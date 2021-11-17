package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    @SneakyThrows
    public WebDriver initDiver(String browser) {

        switch (browser.toUpperCase()){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                webDriverThreadLocal.set(new ChromeDriver());
                break;
            case "FF":
                WebDriverManager.firefoxdriver().setup();
                webDriverThreadLocal.set(new FirefoxDriver());
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                webDriverThreadLocal.set(new InternetExplorerDriver());
                break;
            default:
                throw new Exception("Please Pass the valid value");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }



    public static WebDriver getDriver(){
        return webDriverThreadLocal.get();
    }
}
