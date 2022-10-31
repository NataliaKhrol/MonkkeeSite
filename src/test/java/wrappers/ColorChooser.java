package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ColorChooser {
    String label;
    WebDriver driver;

    public ColorChooser(String label, WebDriver driver) {
        this.driver = driver;
        this.label = label;
    }

    public void chooseField() {
        driver.findElement(By.cssSelector(String.format("[href=\"javascript:void('%s')\"]", label))).click();
        driver.switchTo().frame(0);
       // driver.findElement(By.xpath(String.format("//a[@title=\"%s\"]", label))).click();
    }

    public void chooseColor() {
     //   driver.findElement(By.cssSelector(String.format("[href=\"javascript:void('%s')\"]", label))).click();
      //  driver.switchTo().frame(0);
        driver.findElement(By.xpath(String.format("//a[@title=\"%s\"]", label))).click();
        driver.switchTo().defaultContent();
    }
////a[@title="Strong Blue"]
}
