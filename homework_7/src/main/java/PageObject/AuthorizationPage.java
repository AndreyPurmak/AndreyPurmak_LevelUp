package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Properties;

public class AuthorizationPage extends BasePage {

    public AuthorizationPage (WebDriver driver)
    {
        super(driver);
    }

    @FindBy (css = "#mailbox [name='login']")
    private WebElement loginField;

    @FindBy (css = "#mailbox [type=password]")
    private WebElement passwordField;

    @FindBy (xpath = "//*[@id='mailbox:submit-button']")
    private WebElement submitButton;

    public void authorize() {
        Properties loginPropetries = new Properties();
        try {
            loginPropetries.load(this.getClass().getClassLoader().getResourceAsStream("login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String login = loginPropetries.getProperty("login");
        String password = loginPropetries.getProperty("password");

        loginField.sendKeys(login);
        submitButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        submitButton.click();
    }
}
