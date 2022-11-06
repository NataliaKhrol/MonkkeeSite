package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

@Log4j2
public class FileAttach {
    WebDriver driver;
    String label;

    public FileAttach(WebDriver driver) {
        this.driver = driver;
        this.label = label;
    }

    public void attach() {
        driver.findElement(By.cssSelector("[href=\"javascript:void('Image')\"]")).click();
        final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size() + "MINE");
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("innerHTML"));
        }

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframes.get(0));
        System.out.println(driver.getPageSource());
        WebElement upload_file = driver.findElement(By.cssSelector("input[type=\"file\"]"));
        upload_file.sendKeys(new File("src/test/resources/pics/SportHorse.png").getAbsolutePath());
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
    }
}
