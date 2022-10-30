package pages;

import org.openqa.selenium.WebDriver;
import wrappers.BackgroundColorChooser;
import wrappers.Option;

public class EditTextPage extends BasePage {
    public EditTextPage(WebDriver driver) {
        super(driver);
    }

    public void create(String label, String label2, String label3, String label4) {
        new Option(label, driver).select();
        new Option(label2, driver).select();
        new Option(label3, driver).select();
        new BackgroundColorChooser(label4, driver).choose();
    }
}
