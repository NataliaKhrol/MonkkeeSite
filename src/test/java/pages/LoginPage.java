package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @Step("Login by {email} and {password}")
    public void login(String user, String password) {
        driver.findElement(ACCOUNT_BUTTON).click();
        driver.findElement(USER_ENTRY).sendKeys(user);
        driver.findElement(PASSWORD_ENTRY).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

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
