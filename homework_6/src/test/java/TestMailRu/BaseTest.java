package TestMailRu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert soft = new SoftAssert();

    public final String URL = "https://mail.ru/";
    public final String LOGIN = "testpurmakmail";
    public final String PASSWORD = "Test1010101010";
    public final String EMAIL = "testpurmakmail@mail.ru";
    public final String DESTINATION = "andreypurmak@gmail.com";
    public final String SUBJECT = "Mail";
    public final String SUBJECT_TEST = "Тест mail";
    public final String BODY = "Homework 6 Test Mail.ru";

    public void login (String login, String password) {
        driver.get(URL);
        WebElement loginWindow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mailbox [name='login']")));
        loginWindow.sendKeys(login);

        WebElement submitLogin = driver.findElement(By.xpath("//*[@id='mailbox:submit-button']"));
        submitLogin.click();

        WebElement passwordWindow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mailbox [type=password]"))) ;
        passwordWindow.sendKeys(password);

        WebElement submitPassword = driver.findElement(By.xpath("//*[@id='mailbox:submit-button']"));
        submitPassword.click();
    }

    public void logout() {
        driver.findElement(By.id("PH_logoutLink"))
                .click();
    }
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        login(LOGIN, PASSWORD);
    }

    @AfterMethod
    public void tearDown() {
        logout();
        driver.quit();
    }

}
