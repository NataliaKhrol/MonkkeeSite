package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.EditTextPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class EntryTest extends BaseTest {

    @Test
    public void publishInfo() {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.entryData();
        entriesPage.saveData();
        assertEquals("The message was not published", "Es ist etwas Schönes, sein eigenes Bild im liebenden Auge zu erblicken.", entriesPage.checkEntry());
    }

    @Test
    public void editEntry() {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.entryData();
        entriesPage.mark();
        new EditTextPage(driver).create("Underline", "Bold", "Insert/Remove Bulleted List", "Pale Red");
    }
}