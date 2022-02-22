package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InteractionsPage extends ParentPage {

    @FindBy(xpath = ".//*[text()='Selectable']")
    private WebElement selectableButton;

    public InteractionsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/interaction";
    }

    public InteractionsPage checkIsRedirectToInteractionsPage() {
        checkUrl();
        logger.info("Is redirected to InteractionsPage");
        return this;
    }

    public SelectablePage clickOnSelectableButton() {
        scrollToTheElement(selectableButton);
        clickOnElement(selectableButton);
        return new SelectablePage(webDriver);
    }

}
