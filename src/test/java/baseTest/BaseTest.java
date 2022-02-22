package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected ElementsPage elementsPage;
    protected HomePage homePage;
    protected RadioButtonPage radioButtonPage;
    protected BookStoreApplicationPage bookStoreApplicationPage;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;
    protected InteractionsPage interactionsPage;
    protected SelectablePage selectablePage;
    protected BrokenLinksPage brokenLinksPage;

    @Before
    public void setUp() {
        logger.info("----" + testName.getMethodName() + " was started -------");
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        elementsPage = new ElementsPage(webDriver);
        homePage = new HomePage(webDriver);
        radioButtonPage = new RadioButtonPage(webDriver);
        bookStoreApplicationPage = new BookStoreApplicationPage(webDriver);
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        interactionsPage = new InteractionsPage(webDriver);
        selectablePage = new SelectablePage(webDriver);
        brokenLinksPage = new BrokenLinksPage(webDriver);


    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
        logger.info("----" + testName.getMethodName() + " was ended -------");
        logger.info("");
    }

    @Rule
    public TestName testName = new TestName();

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }
}
