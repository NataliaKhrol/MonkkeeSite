package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class EntryTest extends BaseTest {

    @Test
    public void publishInfo() {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.entryData();
        assertEquals("The message was not published", "Es ist etwas Schönes, sein eigenes Bild im liebenden Auge zu erblicken.", entriesPage.checkEntry());
    }
}
