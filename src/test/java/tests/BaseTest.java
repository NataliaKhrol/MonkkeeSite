package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.EntriesPage;
import pages.LoginPage;
import pages.SupportPage;
import utils.PropertyReader;


import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    EntriesPage entriesPage;
    SupportPage supportPage;
    String user;
    String password;


    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // options.setHeadless(true);
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            //TODO implement firefox opening
        }
        Configuration.baseUrl = System.getProperty("MONKKEE_URL", PropertyReader.getProperty("monkkee.url"));
        user = PropertyReader.getProperty("monkkee.user");
        password = PropertyReader.getProperty("monkkee.password");

        testContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        supportPage = new SupportPage(driver);
        entriesPage = new EntriesPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (driver != null) {
         //   driver.quit();
        }
    }
}


