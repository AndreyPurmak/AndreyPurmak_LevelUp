package TestMailRu;

import PageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    private WebDriver driver;
    protected AuthorizationPage authorizationPage;
    protected WebDriverWait wait;
    protected MailPage mailPage;
    protected CreateLetterPage createLetterPage;
    protected SoftAssert soft = new SoftAssert();
    protected OpenedLetterPage openedLetterPage;
    protected DraftPage draftPage;


    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        authorizationPage = new AuthorizationPage(driver);
        mailPage = new MailPage(driver);
        createLetterPage = new CreateLetterPage(driver);
        openedLetterPage = new OpenedLetterPage(driver);
        draftPage = new DraftPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://mail.ru/");
        authorizationPage.authorize();
    }

    @AfterMethod
    public void tearDown() {
        mailPage.logout();
        driver.quit();
    }
}
