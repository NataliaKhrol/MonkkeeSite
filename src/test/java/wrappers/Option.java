package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Option {
    String label;
    WebDriver driver;

    public Option(String label, WebDriver driver) {
        this.driver = driver;
        this.label = label;
    }

    public void select() {
        driver.findElement(By.cssSelector(String.format("[href=\"javascript:void('%s')\"]", label))).click();
    }
}
