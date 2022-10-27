package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage extends BasePage {

    private By SEARCH_FIELD = By.id("appendedInputButton");
    private By SEARCH_BUTTON = By.cssSelector("[title=\"Search\"]");
    private By MANAGE_TAG = By.xpath("//a[contains(text(),'Manage tags')]");
    private By DELETE_TAG = By.cssSelector("[class=\"icon-trash icon-white\"]");

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


    public void manageTags() {
        driver.findElement(MANAGE_TAG).click();
        driver.findElement(DELETE_TAG).click();
    }

    public String allertMessage() {
      return driver.switchTo().alert().getText();
    }

       // Alert alert = getWebDriver().switchTo().alert();
      //  String alertText = alert.getText();
      //  System.out.println(alertText);
    }

