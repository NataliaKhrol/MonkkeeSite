package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import wrappers.ColorChooser;
import wrappers.Dropdown;
//import wrappers.FileAttach;
import wrappers.FileAttach;
import wrappers.Option;

public class EditTextPage extends BasePage {
    public EditTextPage(WebDriver driver) {
        super(driver);
    }

    @Step("Change the style of the words")
    public void createStyle(String label, String label2, String label3) {
        new Option(label, driver).select();
        new Option(label2, driver).select();
        new Option(label3, driver).select();
    }

    @Step("Change the color of the words")
    public void changeColor(String label1, String label2) {
        new ColorChooser(label1, driver).chooseField();
        new ColorChooser(label2, driver).chooseColor();
    }

    @Step("Create new heading style")
    public void changeHeading(String label) {
        new Dropdown(driver).chooseHeading(label);
    }

    public void attachFile() {
        new FileAttach(driver).attach();
    }
}

