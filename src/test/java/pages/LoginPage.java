package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void Login(){
        driver.findElement(By.xpath("//a[contains(text(),'To my account')]")).click();
    }
}
