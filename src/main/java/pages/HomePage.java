package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[h5='Elements']")
    public WebElement elementsButton;

    @FindBy(xpath = ".//*[h5='Book Store Application']")
    public WebElement bookStoreApplicationButton;

    @FindBy(xpath = ".//*[h5='Interactions']")
    public WebElement interactionsButton;

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public void openHomePage() {
        try {
            webDriver.get(baseUrl + "/");
            logger.info("Home page was opened");
        } catch (Exception e) {
            logger.error("Can not open Home Page" + e);
            Assert.fail("Can not open Home Page" + e);
        }
    }

    public ElementsPage clickOnElementsButton() {
        clickOnElement(elementsButton);
        return new ElementsPage(webDriver);
    }


    public BookStoreApplicationPage clickOnBookStoreApplicationButton() {
        scrollToTheElement(bookStoreApplicationButton);
        clickOnElement(bookStoreApplicationButton);
        return new BookStoreApplicationPage(webDriver);
    }

    public InteractionsPage clickOnInteractionsButton() {
        clickOnElement(interactionsButton);
        return new InteractionsPage(webDriver);
    }
}
