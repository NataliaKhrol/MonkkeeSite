package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class SupportTest extends BaseTest {

    @Test(description = "Checking the redirection to Support department")
    public void switchSupport() {
        loginPage.openPage();
        supportPage.switchSupport();
        log.error("The link 'Support' is not active");
        supportPage.supportpageOpen();
    }
}


//  WebElement element = wait.until(ExpectedConditions.elementToBeClickable());
// element.click();
