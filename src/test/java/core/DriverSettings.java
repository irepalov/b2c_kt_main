package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class DriverSettings {
    private static final String FIREFOX = "firefox";
    private static final String IE = "ie";
    private static final String DEFAULT = "chrome";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public static void Setup() {
        // Uses chrome driver by default
        String browser = System.getenv("BROWSER");
        if (browser == null) {
            browser = DEFAULT;
        }

        if (browser.toLowerCase().equals(FIREFOX)) {
            //WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.setProperty("webdriver.gecko", "c://tools/geckodriver");
            DriverSettings.driver.get("http://185.141.227.202");
            driver.manage().window().maximize();
        } else if (browser.toLowerCase().equals(IE)) {
            //WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.setProperty("webdriver.chrome", "C://Tools//chromedriver.exe");
            DriverSettings.driver.get("http://185.141.227.202");
            driver.manage().window().maximize();
        }
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
        driver.quit();
    }
}
