package TestMailRu.Tests;

import TestMailRu.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise2Test extends BaseTest {

    @Test
    public void executeExerciseTwo() {

        /* Assertion of Login */
        WebElement sendMessageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("compose-button__txt")));
        assertEquals(sendMessageButton.getText(), "Написать письмо");

        /* Creation of letter */
        sendMessageButton.click();
        WebElement addressee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-name='to'] input")));
        addressee.sendKeys(EMAIL);
        WebElement subject = driver.findElement(By.cssSelector("input[name='Subject']"));
        subject.sendKeys(SUBJECT_TEST);
        WebElement body = driver.findElement(By.cssSelector("[role='textbox']"));
        body.sendKeys(BODY);

        /* Sending letter */
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Отправить']")));
        sendButton.click();
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Закрыть']")));
        closeButton.click();

        /* Going to Sent folder and verify that letter is there  */
        WebElement sentFolder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Отправленные')]")));
        sentFolder.click();
        soft.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='llc__snippet'][1]"))).getText(), BODY);

        /* Going to Test folder and verify that letter is there  */
        WebElement testFolder = driver.findElement(By.xpath("//div[contains(text(),'Тест')]"));
        testFolder.click();
        soft.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='llc__snippet'][1]"))).getText(), BODY);

        /* Open letter and verify content  */
        WebElement testMailBody = driver.findElement(By.xpath("//*[text()[contains(.,'" + BODY +"')]]"));
        testMailBody.click();
        String mailDestinationAddress = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='letter__author']/span"))).getAttribute("title");
        String mailSubject = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='thread__header']//h2"))).getText();
        String mailBody = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[contains(text(), 'Test Mail.ru')]"))).getText();
        soft.assertEquals(mailDestinationAddress, EMAIL);
        soft.assertEquals(mailSubject, SUBJECT_TEST);
        soft.assertEquals(mailBody, BODY);

        soft.assertAll();
    }
}
