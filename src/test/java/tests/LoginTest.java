package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Checking users authorization")
    public void correctLogin() {
        loginPage.openPage();
        loginPage.login(user, password);
        //basePage.closePopUpIfDisplayed();
        assertTrue(loginPage.open(), "Login failed");
    }

    @Test(description = "Checking the authorization when the required fields are left unfilled")
    public void emptyFields() {
        loginPage.openPage();
        loginPage.login(" ", " ");
        assertTrue(loginPage.failOpen(), "There are necessary fields to be filled in");
    }

    @Test(description = "Checking the password recovery")
    public void forgotPassword() {
        loginPage.openPage();
        loginPage.passwordRecovery();
        assertTrue(loginPage.passwordReminderSent(), "Page not found");
    }

    @Test(description = "Checking the registration of new users")
    public void registerFirst() {
        loginPage.openPage();
        loginPage.registrationCheck();
        assertTrue(loginPage.registration(), "Registration failed");

    }
}
