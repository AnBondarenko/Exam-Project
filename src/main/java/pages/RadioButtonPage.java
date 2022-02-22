package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RadioButtonPage extends ParentPage {

    private String radioButtonValue = ".//label[text()='%s']";

    private String chosenRadioButtonValue = ".//*[@class='text-success' and text()='%s']";


    public RadioButtonPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/radio-button";
    }

    public RadioButtonPage selectValueForRadioButton(String value) {
        clickOnElement(String.format(radioButtonValue, value));
        return new RadioButtonPage(webDriver);
    }

    public RadioButtonPage checkValueIsSelected(String value) {
        WebElement webElement = webDriver.findElement(By.xpath(String.format(chosenRadioButtonValue, value)));
        logger.info("Value " + value + " was selected");
        Assert.assertTrue("Value is not chosen", isElementDisplayed(webElement));
        return this;

    }

}
