package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProfilePage extends ParentPage {

    @FindBy(id = "gotoStore")
    private WebElement goToBookStoreButton;


    @FindBy(xpath = ".//*[@class='text-right button di']")
    private WebElement deleteAllBooksButton;

    @FindBy(id = "closeSmallModal-ok")
    private WebElement confirmationButton;

    private String bookTitle = ".//*[text()='%s']";


    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/profile";
    }

    public boolean isButtonLogOutIsDisplayed() {
        try {
            return webDriver.findElement(By.xpath(".//*[@id='submit' and text() = 'Log out']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public ProfilePage checkIsButtonLogOutIsDisplayed() {
        Assert.assertTrue("Button Log Out is not displayed", isButtonLogOutIsDisplayed());
        return this;
    }

    public BookStoreApplicationPage clickOnGoToBookStoreButton() {
        clickOnElement(goToBookStoreButton);
        return new BookStoreApplicationPage(webDriver);
    }

    public ProfilePage checkBookIsInList(String title) {
        List<WebElement> bookList = webDriver.findElements(By.xpath(String.format(bookTitle, title)));
        Assert.assertEquals("Number of books with title " + title, 1, bookList.size());
        return this;
    }

    public ProfilePage clickOnDeleteAllBooksButton() {
        clickOnElement(deleteAllBooksButton);
        return new ProfilePage(webDriver);
    }

    public ProfilePage clickOnConfirmationButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        clickOnElement(confirmationButton);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        return new ProfilePage(webDriver);
    }

}
