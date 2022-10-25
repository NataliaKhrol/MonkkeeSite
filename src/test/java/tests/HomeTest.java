package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void search() {
        loginPage.openPage();
        loginPage.login(user, password);
        homePage.search("liebe");
        assertTrue(homePage.isFound(), "ups");
    }
}
