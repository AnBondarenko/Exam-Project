package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/login";
    }

    public void enterUserNameIntoUserNameField(String username) {
        enterTextIntoElement(userNameField, username);
    }

    public void enterPasswordIntoPasswordField(String password) {
        enterTextIntoElement(passwordField, password);
    }

    public ProfilePage clickOnLoginButton() {
        clickOnElement(loginButton);
        return new ProfilePage(webDriver);
    }

}
