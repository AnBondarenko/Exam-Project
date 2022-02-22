package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStoreApplicationPage extends ParentPage {

    @FindBy(xpath = ".//span[text()='Login']")
    private WebElement loginButton;

    private String bookTitle = ".//*[text()='%s']";

    @FindBy(xpath = ".//*[text()='Add To Your Collection']")
    private WebElement addToYourCollectionButton;

    @FindBy(xpath = ".//span[text()='Profile']")
    private WebElement profileButton;

    public BookStoreApplicationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/books";
    }


    public LoginPage clickOnLoginButton() {
        scrollToTheElement(loginButton);
        clickOnElement(loginButton);
        return new LoginPage(webDriver);
    }

    public BookStoreApplicationPage selectBookTitle(String value) {
        WebElement webElement = webDriver.findElement(By.xpath(String.format(bookTitle, value)));
        scrollToTheElement(webElement);
        clickOnElement(String.format(bookTitle, value));
        return new BookStoreApplicationPage(webDriver);
    }

    public BookStoreApplicationPage clickOnAddToYourCollectionButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        clickOnElement(addToYourCollectionButton);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        return new BookStoreApplicationPage(webDriver);
    }

    public ProfilePage clickOnProfileButton() {
        scrollToTheElement(profileButton);
        clickOnElement(profileButton);
        return new ProfilePage(webDriver);
    }

}
