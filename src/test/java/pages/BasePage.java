package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Data
@Log4j2
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public static final String BASE_URL = "https://monkkee.com/en/";
    String entry = PropertyReader.getProperty("monkkee.entry");

    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //открывает браузер в полном окне
    }
}

