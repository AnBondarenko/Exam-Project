package interactionsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class SelectableTest extends BaseTest {

    final String list = "Morbi leo risus";

    @Test
    public void selectListTest() {
        homePage.openHomePage();
        homePage.clickOnInteractionsButton();
        interactionsPage.checkIsRedirectToInteractionsPage();
        interactionsPage.clickOnSelectableButton();
        selectablePage.selectList(list);
        selectablePage.checkListIsSelected(list);

    }
}
