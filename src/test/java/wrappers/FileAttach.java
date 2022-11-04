package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileAttach {
    WebDriver driver;
    String label;

    public FileAttach() {
        this.driver = driver;
        this.label = label;
    }
    public void attach() {
        driver.findElement(By.xpath("//input[@name=\"txtUpload\"]")).click();
    }
}
