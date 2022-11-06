package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {
    WebDriver driver;

    public Dropdown(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseHeading(String label) {
        driver.findElement(By.cssSelector("[href=\"javascript:void('Paragraph Format')\"]")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath(String.format("//a[@title='%s']", label)));
    }
}


