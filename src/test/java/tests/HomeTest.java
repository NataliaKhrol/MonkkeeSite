package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void search() {
        loginPage.openPage();
        loginPage.login(user, password);
        homePage.search("liebe");
        assertTrue(homePage.isFound(), "The search has failed");
    }

    @Test
    public void Tags() {
        loginPage.openPage();
        loginPage.login(user, password);
        homePage.manageTags();
        assertEquals(homePage.allertMessage(),"Do you really want to delete the tag? All entries related to the tag remain unchanged.");

    }
}
