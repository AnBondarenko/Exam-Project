package bookStoreApplicationTests;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.After;
import org.junit.Test;

public class ProfileTest extends BaseTest {
    final String title = "Understanding ECMAScript 6";

    @Test
    public void AddBookToTheUserCollection() {
        homePage.openHomePage();
        homePage.clickOnBookStoreApplicationButton();
        bookStoreApplicationPage.clickOnLoginButton();
        loginPage.enterUserNameIntoUserNameField(TestData.VALID_USERNAME);
        loginPage.enterPasswordIntoPasswordField(TestData.VALID_PASSWORD);
        loginPage.clickOnLoginButton();
        profilePage.checkIsButtonLogOutIsDisplayed();
        profilePage.clickOnGoToBookStoreButton();
        bookStoreApplicationPage.selectBookTitle(title);
        bookStoreApplicationPage.clickOnAddToYourCollectionButton();
        bookStoreApplicationPage.clickOnProfileButton();
        profilePage.checkBookIsInList(title);


    }

    @After
    public void deleteBooksFromUserList() {
        homePage.openHomePage();
        homePage.clickOnBookStoreApplicationButton();
        bookStoreApplicationPage.clickOnProfileButton();
        profilePage.isButtonLogOutIsDisplayed();
        profilePage.clickOnDeleteAllBooksButton();
        profilePage.clickOnConfirmationButton();

    }
}

