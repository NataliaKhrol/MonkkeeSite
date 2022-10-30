package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackgroundColorChooser {
    String label;
    WebDriver driver;

    public BackgroundColorChooser(String label, WebDriver driver) {
        this.driver = driver;
        this.label = label;
    }

    public void choose() {
        driver.findElement(By.cssSelector("[href=\"javascript:void('Background Color')\"]")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath(String.format("//a[@title=\"%s\"]", label))).click();
    }
////a[@title="Strong Blue"]
}
