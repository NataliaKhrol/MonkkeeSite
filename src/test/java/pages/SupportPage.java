package pages;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class SupportPage extends BasePage {
    public SupportPage(WebDriver driver) {
        super(driver);
    }

    private By PAGE_LOGO = By.xpath("//a[contains(text(),'Help Desk')]");

    public void switchSupport() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'FAQ / Support')]"))).click().perform();
    }

    public boolean supportpageOpen() {
        return driver.findElement(PAGE_LOGO).isDisplayed();
    }
}

//  WebElement element = wait.until(ExpectedConditions.elementToBeClickable());
// element.click();
            /*  Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        System.out.println("No. of tabs: " + tabs.size());

//driver.switchTo().window()*/