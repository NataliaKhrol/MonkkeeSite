package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test(description = "Checking the Search field")
    public void search() {
        loginPage.openPage();
        loginPage.login(user, password);
        homePage.search("liebe");
        assertTrue(homePage.isFound(), "The search has failed");
    }

    @Test(description = "Checking the tag removal")
    public void editTags() {
        loginPage.openPage();
        loginPage.login(user, password);
        homePage.deleteTags();
        assertEquals(homePage.alertMessage(), "Do you really want to delete the tag? All entries related to the tag remain unchanged.");
    }

    @Test(description = "Checking the tag placement")
    public void createTags() {
        loginPage.openPage();
        loginPage.login(user, password);
        homePage.createTag("Schone");
        assertEquals(homePage.isCreated(), "Schone", "OPs");
    }
}
