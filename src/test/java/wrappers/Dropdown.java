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

    public void chooseHeading() {
      //  driver.findElement(By.cssSelector("[class=\"cke_combo_arrow\"]\n")).click();
        driver.findElement(By.cssSelector("[href=\"javascript:void('Paragraph Format')\"]")).click();
     // driver.switchTo().frame(0);
        driver.findElement(By.xpath("//a[@href=\"javascript:void('Paragraph Format')\"]/..//span[@class=\"cke_combo_text\"]"));
        // driver.findElement(By.xpath(String.format("//a[@title=\"%s\"]", label))).click();
    }

  /*  public void chooseColor() {
        //   driver.findElement(By.cssSelector(String.format("[href=\"javascript:void('%s')\"]", label))).click();
        //  driver.switchTo().frame(0);
        driver.findElement(By.xpath(String.format("//a[@title=\"%s\"]", label))).click();
        driver.switchTo().defaultContent();
    }*/

}
