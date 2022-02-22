package bookStoreApplicationTests;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginTestWithValidData() {
        homePage.openHomePage();
        homePage.clickOnBookStoreApplicationButton();
        bookStoreApplicationPage.clickOnLoginButton();
        loginPage.enterUserNameIntoUserNameField(TestData.VALID_USERNAME);
        loginPage.enterPasswordIntoPasswordField(TestData.VALID_PASSWORD);
        loginPage.clickOnLoginButton();
        profilePage.checkIsButtonLogOutIsDisplayed();

    }
}
