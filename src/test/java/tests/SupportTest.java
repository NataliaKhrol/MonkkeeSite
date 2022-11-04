package tests;

import lombok.extern.log4j.Log4j2;

import org.testng.annotations.Test;

@Log4j2
public class SupportTest extends BaseTest {

    @Test(description = "Checking the redirection to Support department")
    public void switchSupport() {
        loginPage.openPage();
        supportPage.switchSupport();
        supportPage.supportPageOpen();
    }
}


//  WebElement element = wait.until(ExpectedConditions.elementToBeClickable());
// element.click();
