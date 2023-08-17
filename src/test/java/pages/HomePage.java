package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "#inputName")
    public WebElement textBox_Name;

    @FindBy(xpath = "//div[@class='col-sm-10']//input[@id='inputBirthday']")
    public WebElement textBox_birthday;

    @FindBy(css = "#submitButton")
    public WebElement button_submit;

    @FindBy(xpath = "//div[@class='show']//span[@id='resultName']")
    public WebElement text_nameOfUser;
    @FindBy(xpath = "//div[@class='show']//span[@id='resultAge']")
    public WebElement text_ageOfUser;


}
