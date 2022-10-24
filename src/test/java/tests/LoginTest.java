package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test
    public void correctLogin() {
        loginPage.openPage();
        loginPage.login(user, password);
        assertTrue(loginPage.open(), "Login failed");
    }

    @Test
    public void emptyFields() {
        loginPage.openPage();
        loginPage.login(" ", " ");
        log.error("All the fields should be filled in correctly");
        assertTrue(loginPage.failOpen(), "There are necessary fields to be filled in");
    }

    @Test
    public void forgotPassword() {
        loginPage.openPage();
        driver.findElement(By.xpath("//a[contains(text(),'To my account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Send password reminder')]")).click();
        boolean isSwitched = driver.findElement(By.xpath("//h1[contains(text(),'Send yourself a password reminder')]")).isDisplayed();
        assertTrue(isSwitched, "Page not found");
    }

    @Test
    public void registerFirst() {
        loginPage.openPage();
        loginPage.registrationCheck();
        log.error("The link to a Registration form is not active");
        assertTrue(loginPage.registration(), "Registration failed");

    }
}
