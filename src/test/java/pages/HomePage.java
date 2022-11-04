package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By SEARCH_FIELD = By.id("appendedInputButton");
    private By SEARCH_BUTTON = By.cssSelector("[title=\"Search\"]");
    private By MANAGE_TAG = By.xpath("//a[contains(text(),'Manage tags')]");
    private By DELETE_TAG = By.cssSelector("[class=\"icon-trash icon-white\"]");
    private By ENTRY_FIELD = By.cssSelector("[class=\"icon-plus\"]");
    private By TAG_CREATE = By.id("new-tag");
    private By NEW_TAG = By.id("assign-new-tag");
    private By TAG_CHOICE = By.xpath("(//span[@class=\"tag-wrapper ng-scope\"])[1]");
    private By SEARCH_RESULT = By.cssSelector("[class=\"search-explanation ng-binding\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Commit search by word")
    public void search(String searchText) {
        driver.findElement(SEARCH_FIELD).sendKeys(searchText);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public boolean isFound() {
        return driver.findElement(SEARCH_RESULT).isDisplayed();
    }

    //TODO remove comments

    @Step("Delete tags in the dairy entry")
    public void deleteTags() {
        driver.findElement(MANAGE_TAG).click();
        driver.findElement(DELETE_TAG).click();
    }

    public String allertMessage() {
        return driver.switchTo().alert().getText();
    }

    @Step("Create new tags in the dairy entry")
    public void createTag(String bb) {
        driver.findElement(ENTRY_FIELD).click();
        driver.findElement(TAG_CREATE).sendKeys(bb);
        driver.findElement(NEW_TAG).click();
    }

    public String isCreated() {
        return driver.findElement(TAG_CHOICE).getText();
    }

    public void feedMonkkee() {

    }
    // Alert alert = getWebDriver().switchTo().alert();
    //  String alertText = alert.getText();
    //  System.out.println(alertText);
}

