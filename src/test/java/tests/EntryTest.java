package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditTextPage;

import static org.testng.AssertJUnit.assertEquals;

public class EntryTest extends BaseTest {

    @Test(dataProvider = "Entry dairy text", description = "Entry the info to the dairy", invocationCount = 3)
    public void publishInfo(String error, String text) {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.entryData();
        entriesPage.saveData();
        assertEquals(error, text, entriesPage.checkEntry());
    }

    @Test(description = "Changing the fonts, sizes, colors of the text printed")
    public void editText() {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.entryData();
        entriesPage.selectAll();
        new EditTextPage(driver).createStyle(labelUnderline, labelBold, labelList);
        new EditTextPage(driver).changeHeading("Heading 1");
    }

    @Test(description = "Changing the color of the text printed")
    public void changeColor() {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.entryData();
        entriesPage.selectAll();
        new EditTextPage(driver).changeColor("Text Color", "Bright Blue");
    }

    @DataProvider(name = "Entry dairy text")
    public Object[][] dairyText() {
        return new Object[][]{
                {"The message was not published",
                        "Es ist etwas Schones, sein eigenes Bild im liebenden Auge zu erblicken."},
        };
    }

    @Test
    public void attachFile() {
        loginPage.openPage();
        loginPage.login(user, password);
        entriesPage.switchToEntry();
        new EditTextPage(driver).attachFile();
    }
}