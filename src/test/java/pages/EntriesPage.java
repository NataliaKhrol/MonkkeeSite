package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class EntriesPage extends BasePage {

    private By ENTRY_FIELD = By.cssSelector("[class=\"icon-plus\"]");
    private By ENTRY_INFO = By.id("editable");
    private By SAVE_BUTTON = By.xpath("//span[contains(text(),'unsaved')]");
    private By BACK_BUTTON = By.cssSelector("[title=\"Back to overview\"]");
    private By ENTRY_AREA = By.cssSelector("[class=\"cke_toolbar cke_toolbar_last\"]");
    private By TEXT_PRINT = By.xpath("(//a[@class=\"entry\"])[2]");


    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create new dairy entry")
    public void entryData() {
        driver.findElement(ENTRY_FIELD).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ENTRY_AREA));
        driver.findElement(ENTRY_INFO).sendKeys("Es ist etwas Schönes, sein eigenes Bild im liebenden Auge zu erblicken.");
    }

    @Step("Save new entry")
    public void saveData() {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(SAVE_BUTTON, "unsaved"));
        driver.findElement(BACK_BUTTON).click();
    }

    @Step("Select the printed text")
    public void selectAll() {
        driver.findElement(ENTRY_INFO).sendKeys(Keys.CONTROL + "a");
        // element.sendKeys(Keys.CONTROL+"a");
    }

    @Step("Check that the new dairy is saved")
    public String checkEntry() {
        String dairyEntry = driver.findElement(TEXT_PRINT).getText();
        return dairyEntry;
    }
}
//Отформатировать и переменные и собака тест убрать