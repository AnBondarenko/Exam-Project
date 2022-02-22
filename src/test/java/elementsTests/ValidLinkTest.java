package elementsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class ValidLinkTest extends BaseTest {
    final String name = "Click Here for Valid Link";

    @Test
    public void ValidLinkTest() {
        homePage.openHomePage();
        homePage.clickOnElementsButton();
        elementsPage.clickOnBrokenLinksButton();
        brokenLinksPage.checkIsRedirectToBrokenLinksPage();
        brokenLinksPage.clickOnLink(name);
        brokenLinksPage.checkLinkIsValid();

    }
}
