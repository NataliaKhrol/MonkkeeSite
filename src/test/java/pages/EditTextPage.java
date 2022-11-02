package pages;

import org.openqa.selenium.WebDriver;
import wrappers.ColorChooser;
import wrappers.Dropdown;
import wrappers.Option;

public class EditTextPage extends BasePage {
    public EditTextPage(WebDriver driver) {
        super(driver);
    }

    public void create(String label, String label2, String label3, String label4, String label5) {
        new Option(label, driver).select();
        new Option(label2, driver).select();
        new Option(label3, driver).select();
        new ColorChooser(label4, driver).chooseField();
        new ColorChooser(label5, driver).chooseColor();
        new Dropdown(driver).chooseHeading();
     //   new ColorChooser(label6, driver).chooseField();
    //    new ColorChooser(label7, driver).chooseColor();

    }
}
