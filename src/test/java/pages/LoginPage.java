package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By ACCOUNT_BUTTON = By.xpath("//a[contains(text(),'To my account')]");
    private By USER_ENTRY = By.cssSelector("[placeholder=\"Email address or alias\"]");
    private By PASSWORD_ENTRY = By.id("password");
    private By LOGIN_BUTTON = By.cssSelector("[class=\"btn-text-content\"]");
    private By MAIN_BUTTON = By.cssSelector("[class=\"icon-plus\"]");
    private By WARNING_MESSAGE = By.xpath("//div[contains(text(),'Mandatory field')]");
    private By REGISTER_REQUIRED = By.xpath("//a[contains(text(),'Register')]");
    private By REGISTRATION_FORM = By.xpath("//h1[contains(text(),'Registration')]");
    private By PASSWORD_REMINDER = By.xpath("//a[contains(text(),'Send password reminder')]");
    private By SEND_REMINDER = By.xpath("//h1[contains(text(),'Send yourself a password reminder')]");

    public void openPage() {

        driver.get(BASE_URL);
    }

    @Step("Login by {email} and {password} preventing popup")
    public void login(String user, String password) {
        loginFast(user, password);
        try {//пытаемся понять произошел ли переход после кликлогин
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(MAIN_BUTTON));
            log.debug("No Wild popup appears during login");
        } catch (TimeoutException e){ // если переход не произошел, пытаемся закрыть окно
            log.debug("Start checking wild popup");
            if (!driver.findElements(By.cssSelector("[class=\"modal-body\"]")).isEmpty()) {
                log.debug("Wild popup is displayed");
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cancel')]"))).click();
                log.debug("Wild popup was closed");
            } else {
                log.warn("Wild popup was NOT displayed");
            }
        }
    }

    @Step("Login by {email} and {password}")
    public void loginFast(String user, String password) {
        driver.findElement(ACCOUNT_BUTTON).click();
        driver.findElement(USER_ENTRY).sendKeys(user);
        driver.findElement(PASSWORD_ENTRY).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }
    /*  private boolean closePopUpIfDisplayed() {
        log.debug("Start checking random message");
        if (!driver.findElements(By.cssSelector("[class=\"modal-body\"]")).isEmpty()) {
            log.debug("Random popup is displayed");
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cancel')]"))).click();
            return true;
        } else {
            log.debug("Random popup IS NOT displayed");
            return false;
        }
    }*/

    public boolean open() {
        return driver.findElement(MAIN_BUTTON).isDisplayed();

    }

    public boolean failOpen() {
        log.error("All the fields should be filled in correctly");
        return driver.findElement(WARNING_MESSAGE).isDisplayed();
    }

    @Step("Register new user")
    public void registrationCheck() {
        driver.findElement(ACCOUNT_BUTTON).click();
        driver.findElement(REGISTER_REQUIRED).click();
    }

    public boolean registration() {
        log.error("The link to a Registration form is not active");
        return driver.findElement(REGISTRATION_FORM).isDisplayed();
    }

    @Step("Recover the password if forgotten")
    public void passwordRecovery() {
        driver.findElement(ACCOUNT_BUTTON).click();
        driver.findElement(PASSWORD_REMINDER).click();
    }

    public boolean passwordReminderSent() {
        return driver.findElement(SEND_REMINDER).isDisplayed();
    }
}
