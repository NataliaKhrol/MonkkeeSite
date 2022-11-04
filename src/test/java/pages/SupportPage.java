package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

@Log4j2
public class SupportPage extends BasePage {
    public SupportPage(WebDriver driver) {
        super(driver);
    }

    private By PAGE_LOGO = By.xpath("//a[contains(text(),'Help Desk')]");
    private By SUPPORT_BUTTON = By.xpath("//a[contains(text(),'FAQ / Support')]");


    public void switchSupport() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(SUPPORT_BUTTON)).click().perform();
    }

    public boolean supportPageOpen() {
        log.error("The link 'Support' is not active");
        return driver.findElement(PAGE_LOGO).isDisplayed();
    }
}

//  WebElement element = wait.until(ExpectedConditions.elementToBeClickable());
// element.click();
            /*  Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        System.out.println("No. of tabs: " + tabs.size());

//driver.switchTo().window()*/
