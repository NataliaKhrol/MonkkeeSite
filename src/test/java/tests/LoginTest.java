package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Checking users authorization")
    public void correctLogin() {
        loginPage.openPage();
        loginPage.login(user, password);
        assertTrue(loginPage.open(), "Login failed");
    }

    @Test(dataProvider = "Data for negative authorization tests",
            description = "Checking the authorization when the required fields are left unfilled")
    public void negativeAuthorization(String user, String password, String error) {
        loginPage.openPage();
        loginPage.loginFast(user, password);
        assertTrue(loginPage.failOpen(), error);
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

    @DataProvider(name = "Data for negative authorization tests")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "There are necessary fields to be filled in"},
                {"", "incorrectPassword", "There are necessary fields to be filled in"},
                {" ", " ", "There are necessary fields to be filled in"},
                {"incorrectLogin", "", "There are necessary fields to be filled in"}
        };
    }
}

