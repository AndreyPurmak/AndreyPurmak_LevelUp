package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenedLetterPage extends BasePage {

    public OpenedLetterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@title='testpurmakmail@mail.ru']")
    private WebElement openLetterForMyself;

    @FindBy (xpath = "//*[@title='Andrey Purmak <testpurmakmail@mail.ru>']")
    private WebElement openLetterForMyselfInInboxFolder;

    @FindBy (xpath = "//*[@title='andreypurmak@gmail.com']")
    private WebElement openLetterForAddressee;

    @FindBy (xpath = "//*[contains(@class, 'contacts')][@data-type='to']//span")
    private WebElement addresseeField;

    @FindBy (xpath = "//*[@name='Subject']")
    private WebElement subjectField;

    @FindBy (xpath = "//*[@class='thread__header']//h2")
    private WebElement subjectFieldInOpenedLetter;

    @FindBy (xpath = "//*[contains(text(), 'Test Mail.ru')]")
    private WebElement bodyField;

    @FindBy (xpath = "//*[@title='Удалить']")
    private WebElement deleteButton;


    public void openLetterForAddressee() {
        wait.until(ExpectedConditions.elementToBeClickable(openLetterForAddressee)).click();
    }

    public WebElement getLetterForMyself() {
         return wait.until(ExpectedConditions.visibilityOf(openLetterForMyself));
    }

    public void openLetterForMyselfInInboxFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(openLetterForMyselfInInboxFolder)).click();
    }


    public WebElement getLetterForMyselfInInboxFolder() {
        return wait.until(ExpectedConditions.visibilityOf(openLetterForMyselfInInboxFolder));
    }

    public WebElement getAddresseeField() {
        return wait.until(ExpectedConditions.visibilityOf(addresseeField));
    }


    public WebElement getSubjectField() {
        return subjectField;
    }

    public WebElement getSubjectFieldInOpenedLetter() {
        return wait.until(ExpectedConditions.visibilityOf(subjectFieldInOpenedLetter));
    }

    public WebElement getBodyField() {
        return wait.until(ExpectedConditions.visibilityOf(bodyField));
    }

    public void deleteLetter() {
        deleteButton.click();
    }
}
