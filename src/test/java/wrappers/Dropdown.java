package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {
    String label;
    WebDriver driver;
    String text;

    public Dropdown(WebDriver driver) {
        this.driver = driver;
        this.label = label;
        this.text = text;
    }

    public void chooseHeading(String label) {
        driver.findElement(By.cssSelector("[href=\"javascript:void('Paragraph Format')\"]")).click();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath(String.format("//a[@title='%$']", label)));
    }
}


  /*  public void chooseColor() {
        //   driver.findElement(By.cssSelector(String.format("[href=\"javascript:void('%s')\"]", label))).click();
        //  driver.switchTo().frame(0);
        driver.findElement(By.xpath(String.format("//a[@title=\"%s\"]", label))).click();
        driver.switchTo().defaultContent();
    }*/

