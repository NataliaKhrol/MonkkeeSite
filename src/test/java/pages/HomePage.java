package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By SEARCH_FIELD = By.id("appendedInputButton");
    private By SEARCH_BUTTON = By.cssSelector("[title=\"Search\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String searchText) {
        driver.findElement(SEARCH_FIELD).sendKeys(searchText);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public boolean isFound() {
        return driver.findElement(By.cssSelector("[class=\"search-explanation ng-binding\"]")).isDisplayed();
    }
}
