package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


abstract public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    WebDriverWait webDriverWait10, webDriverWait15;
    protected String baseUrl = "https://demoqa.com";

    abstract String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("Invalid page", baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
    }

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, 10);
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    protected void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info(webElement + "Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(String xpathLocator) {

        try {
            WebElement webElement = webDriver.findElement(By.xpath(xpathLocator));
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            clickOnElement(webElement);
        } catch (Exception e) {
            logger.info("Element was not found");
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info("Element is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;

        }
    }

    public void scrollToTheElement(WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webElement);
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }

}