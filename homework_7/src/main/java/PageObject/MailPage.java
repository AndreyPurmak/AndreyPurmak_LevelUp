package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends BasePage {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "compose-button__txt")
    private WebElement createNewLetterButton;

    @FindBy(xpath = "//div[contains(text(),'Входящие')]")
    private WebElement openInboxFolder;

    @FindBy (xpath = "//div[contains(text(),'Тест')]")
    private WebElement openTestFolder;

    @FindBy (xpath = "//div[contains(text(),'Отправленные')]")
    private WebElement openSentFolder;

    @FindBy (xpath = "//div[contains(text(),'Черновики')]")
    private WebElement openDraftFolder;

    @FindBy (xpath = "//*[contains(@class, 'nav__folder-name__txt') and contains(text(), 'Корзина')]")
    private WebElement openTrashFolder;

    @FindBy (id = "PH_logoutLink")
    private WebElement exitButton;

    public void writeLetter(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewLetterButton)).click();
    }

    public void goToInboxFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(openInboxFolder)).click();
    }

    public void goToTestFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(openTestFolder)).click();
    }

    public void goToSentFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(openSentFolder)).click();
    }

    public void goToDraftFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(openDraftFolder)).click();
    }

    public void goToTrashFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(openTrashFolder)).click();
    }

    public WebElement createNewLetterButton() {
        return wait.until(ExpectedConditions.visibilityOf(createNewLetterButton));
    }
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(exitButton)).click();
    }


}
