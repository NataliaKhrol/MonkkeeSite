package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import wrappers.ColorChooser;
import wrappers.Dropdown;
import wrappers.FileAttach;
import wrappers.Option;

public class EditTextPage extends BasePage {
    public EditTextPage(WebDriver driver) {
        super(driver);
    }

    @Step("Change the style of the words")
    public void createStyle(String labelUnderline, String labelBold, String labelList) {
        new Option(labelUnderline, driver).select();
        new Option(labelBold, driver).select();
        new Option(labelList, driver).select();
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

