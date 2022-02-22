package elementsTests;

import baseTest.BaseTest;
import org.junit.Test;


public class RadioButtonTest extends BaseTest {
    final String value = "Impressive";

    @Test
    public void RadioButtonTest() {
        homePage.openHomePage();
        homePage.clickOnElementsButton();
        elementsPage.clickOnRadioButton();
        radioButtonPage.selectValueForRadioButton(value);
        radioButtonPage.checkValueIsSelected(value);
    }
}
