package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class EntriesPage extends BasePage {

    private By ENTRY_FIELD = By.cssSelector("[class=\"icon-plus\"]");
    private By ENTRY_INFO = By.id("editable");
    private By SAVE_BUTTON = By.xpath("//span[contains(text(),'unsaved')]");
    private By BACK_BUTTON = By.cssSelector("[title=\"Back to overview\"]");

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Test
    public void entryData() {

        driver.findElement(ENTRY_FIELD).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"cke_toolbar cke_toolbar_last\"]")));
        driver.findElement(ENTRY_INFO).sendKeys("Es ist etwas Schönes, sein eigenes Bild im liebenden Auge zu erblicken.");

    }
    public void saveData(){
        wait.until(ExpectedConditions.invisibilityOfElementWithText(SAVE_BUTTON, "unsaved"));
        driver.findElement(BACK_BUTTON).click();
    }
    public void mark() {
       // String element =
                driver.findElement(ENTRY_INFO).sendKeys(Keys.CONTROL+"a");
       // element.sendKeys(Keys.CONTROL+"a");

    }

    public String checkEntry() {
        String dairyEntry = driver.findElement(By.xpath("(//a[@class=\"entry\"])[2]")).getText();
        return dairyEntry;
    }
}
//Отформатировать и переменные и собака тест убрать