package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void forgotPassword() {
        driver.get("monkkee.url");
        driver.findElement(By.xpath("//a[contains(text(),'To my account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Send password reminder')]")).click();
        boolean isSwitched = driver.findElement(By.xpath("//h1[contains(text(),'Send yourself a password reminder')]")).isDisplayed();
        assertTrue(isSwitched, "Page not found");
    }

    @Test
    public void registerFirst() {
        driver.get("https://www.monkkee.com/en/");
        driver.findElement(By.xpath("//a[contains(text(),'To my account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        boolean isSwitched = driver.findElement(By.xpath("//h1[contains(text(),'Registration')]")).isDisplayed();
        assertTrue(isSwitched, "Page not found");
    }


}
