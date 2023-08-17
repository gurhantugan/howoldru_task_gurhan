package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.LocalDate;
import java.time.Period;

public class US_001 {
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    String expectedName = "";
    int birthDay;
    int birthMonth;
    int birthYear;

    @Given("user goes to homepage and verifies it")
    public void userGoesToHomepageAndVerifiesIt() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homePageUrl"));

        String expectedUrl = "https://howoldru.m-messiah.cc/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("user enters a name {string}")
    public void userEntersAName(String name) {
        expectedName = name;

        homePage.textBox_Name.sendKeys(name);
        actions.sendKeys(Keys.TAB).perform();

        }

    @And("user enters a date of birth {string},{string},{string}")
    public void userEntersADateOfBirth(String day, String month, String year) {
        birthDay= Integer.parseInt(day);
        birthMonth= Integer.parseInt(month);
        birthYear= Integer.parseInt(year);

        //Enter the month, day and year of birthday
        actions.sendKeys(month).sendKeys(day).sendKeys(year).perform();
    }


    @And("user clicks on submit button")
    public void userClicksOnSubmitButton() {

        homePage.button_submit.click();
    }


    @Then("user verifies the name and age")
    public void userVerifiesTheNameAndAge() {
        String actualName = homePage.text_nameOfUser.getText();
        // Assertion of name
        Assert.assertEquals(expectedName, actualName);

        int actualAge = Integer.parseInt(homePage.text_ageOfUser.getText());
        int expectedAge=calculatingAge(birthDay,birthMonth,birthYear);

        // Assertion of age
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedAge,actualAge);

        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);

        System.out.println("expectedAge = " + expectedAge);
        System.out.println("actualAge = " + actualAge);

    }

    @Then("user verifies the warning message {string}")
    public void userVerifiesTheWarningMessage(String WarningMessage) {
        //get warning message after leaving name part empty or
        try {isWarningMessageTrue(WarningMessage);

        }catch(Exception e){
            System.out.println("please enter valid information");
        }

    }



    public int calculatingAge(int birthDay, int birthMonth, int birthYear){

        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Create a LocalDate object for the user's date of birth
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);

        // Calculate the age
        Period age = Period.between(birthDate, currentDate);

        // Print the age
        System.out.println("Age: " + age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days");
        return age.getYears();

    }

    public boolean isWarningMessageTrue(String warningMessage){
        String actualWarningMessage=Driver.getDriver().findElement(By.xpath("//span[text()='"+warningMessage+"']")).getText();
        String expectedWarningMessage=warningMessage;

        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);
        System.out.println("expectedWarningMessage = " + expectedWarningMessage);
        System.out.println("actualWarningMessage = " + actualWarningMessage);

        return true;
    }

}

