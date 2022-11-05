package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    EntriesPage entriesPage;
    SupportPage supportPage;
    HomePage homePage;
    EditTextPage editTextPage;
    String user;
    String password;

    void closePopUpIfDisplayed() {
        log.debug("Start checking random message");
        if (driver.findElement(By.cssSelector("[class=\"modal-body\"]")).isDisplayed()) {
            log.debug("Random popup is displayed");
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cancel')]"))).click();
        } else {
            log.debug("Random popup IS NOT displayed");
        }
    }

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening the browser")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //TODO add headless
            // options.setHeadless(true);
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        Configuration.baseUrl = System.getProperty("MONKKEE_URL", PropertyReader.getProperty("monkkee.url"));
        user = PropertyReader.getProperty("monkkee.user");
        password = PropertyReader.getProperty("monkkee.password");

        context.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        supportPage = new SupportPage(driver);
        entriesPage = new EntriesPage(driver);
        homePage = new HomePage(driver);
        editTextPage = new EditTextPage(driver);
    }

    //TODO uncomment
    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void close() {
        if (driver != null) {
           //   driver.quit();
        }
    }
}


