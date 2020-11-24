package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static config.TestDataConstants.*;

public class CreateLetterPage extends BasePage {

    public CreateLetterPage (WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "[data-name='to'] input")
    private WebElement addresseeField;

    @FindBy (css = "input[name='Subject']")
    private WebElement subjectField;

    @FindBy (css = "[role='textbox']")
    private WebElement bodyField;

    @FindBy (xpath = "//*[@title='Отправить']")
    private WebElement sendLetterButton;

    @FindBy (xpath = "//*[@title='Сохранить']")
    private WebElement saveLetterButton;

    @FindBy (xpath = "//*[@title='Закрыть']")
    private WebElement closeLetterButton;

    public void writeLetterForExerciseOne() {
        wait.until(ExpectedConditions.elementToBeClickable(addresseeField)).click();
        addresseeField.sendKeys(DESTINATION);
        subjectField.sendKeys(SUBJECT);
        bodyField.sendKeys(BODY);
    }

    public void writeLetterForMyselfForTestFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(addresseeField)).click();
        addresseeField.sendKeys(EMAIL);
        subjectField.sendKeys(SUBJECT_TEST);
        bodyField.sendKeys(BODY);
    }

    public void writeLetterForMyself() {
        wait.until(ExpectedConditions.elementToBeClickable(addresseeField)).click();
        addresseeField.sendKeys(EMAIL);
        subjectField.sendKeys(SUBJECT);
        bodyField.sendKeys(BODY);
    }

    public void saveLetter() {
        saveLetterButton.click();
    }

    public void sendLetter() {
        sendLetterButton.click();
    }

    public void closeLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(closeLetterButton)).click();
    }

}
