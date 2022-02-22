package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends ParentPage {

    @FindBy(xpath = ".//*[text()='Radio Button']")
    private WebElement radioButton;

    @FindBy(xpath = ".//*[text()='Broken Links - Images']")
    private WebElement brokenLinkButton;

    public ElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/elements";
    }

    public RadioButtonPage clickOnRadioButton() {
        clickOnElement(radioButton);
        return new RadioButtonPage(webDriver);
    }

    public BrokenLinksPage clickOnBrokenLinksButton (){
        scrollToTheElement(brokenLinkButton);
        clickOnElement(brokenLinkButton);
        return new BrokenLinksPage(webDriver);
    }
}

