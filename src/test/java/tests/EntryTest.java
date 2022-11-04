package tests;

import org.testng.annotations.Test;
import pages.EditTextPage;
import static org.testng.AssertJUnit.assertEquals;

public class EntryTest extends BaseTest {

    @Test(description = "Entry the info to the dairy")
    public void publishInfo() {
        loginPage.openPage();
        loginPage.login(user, password);
        //TODO параметризовать мтеод
        entriesPage.entryData();
        entriesPage.saveData();
        assertEquals("The message was not published", "Es ist etwas Schönes, sein eigenes Bild im liebenden Auge zu erblicken.", entriesPage.checkEntry());
    }

    @Test(description = "Changing the fonts, sizes, colors")
    public void editEntry() {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.entryData();
        entriesPage.selectAll();
        //TODO hide initialization into BaseTest
        new EditTextPage(driver).createStyle(
                "Underline", "Bold", "Insert/Remove Bulleted List");
        new EditTextPage(driver).changeColor("Text Color", "Bright Blue");
        new EditTextPage(driver).changeColor("Text Color", "Bright Blue");
        new EditTextPage(driver).changeHeading("Heading 1");
    }
}
// new EditTextPage(driver).create
//                ("Underline", "Bold", "Insert/Remove Bulleted List",
//                        "Text Color", "Bright Blue", "Background Color", "Bright Silver");