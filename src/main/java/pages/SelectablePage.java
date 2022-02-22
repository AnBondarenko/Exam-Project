package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectablePage extends ParentPage {

    private String list = ".//*[@class='mt-2 list-group-item list-group-item-action' and text()='%s']";
    private String selectedList = ".//*[@class='mt-2 list-group-item active list-group-item-action' and text()='%s']";

    public SelectablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/selectable";
    }

    public SelectablePage selectList(String value) {
        clickOnElement(String.format(list, value));
        return new SelectablePage(webDriver);
    }

    public SelectablePage checkListIsSelected(String value) {
        WebElement webElement = webDriver.findElement(By.xpath(String.format(selectedList, value)));
        logger.info("List " + value + " was selected");
        Assert.assertTrue("List is not selected", isElementDisplayed(webElement));
        return this;

    }
}
