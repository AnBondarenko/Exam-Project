package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class BrokenLinksPage extends ParentPage {

    private String link = ".//[text()='%s']";

    public BrokenLinksPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/broken";
    }

    public HomePage clickOnLink(String value) {
        clickOnElement(String.format(link, value));
        return new HomePage(webDriver);
    }


    public BrokenLinksPage checkIsRedirectToBrokenLinksPage() {
        checkUrl();
        logger.info("Is redirected to BrokenLinkPage");
        return this;
    }

    public HomePage checkLinkIsValid() {
        Assert.assertEquals("Invalid link", baseUrl, webDriver.getCurrentUrl());
        return new HomePage(webDriver);

    }
}
