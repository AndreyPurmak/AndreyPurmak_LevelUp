package TestMailRu.Tests;

import TestMailRu.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise1Test extends BaseTest {

    @Test
    public void runExerciseOne() {

        /* Assertion of Login */
        WebElement sendMessageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("compose-button__txt")));
        assertEquals(sendMessageButton.getText(), "Написать письмо");

        /* Creation of letter */
        sendMessageButton.click();
        WebElement addressee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-name='to'] input")));
        addressee.sendKeys(DESTINATION);
        WebElement subject = driver.findElement(By.cssSelector("input[name='Subject']"));
        subject.sendKeys(SUBJECT);
        WebElement body = driver.findElement(By.cssSelector("[role='textbox']"));
        body.sendKeys(BODY);

        /* Saving letter */
        WebElement savingButton = driver.findElement(By.xpath("//*[@title='Сохранить']"));
        savingButton.click();

        /* Going to Draft Folder */
        WebElement closeButton = driver.findElement(By.cssSelector("[type='button'][title='Закрыть']"));
        closeButton.click();
        WebElement draftButton = driver.findElement(By.xpath("//div[contains(text(),'Черновики')]"));
        draftButton.click();

        /* Verifying Draft folder */
        soft.assertTrue(wait.until(ExpectedConditions.titleIs("Черновики - Почта Mail.ru")));

        /* Verifying content */
        WebElement openSavedLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='andreypurmak@gmail.com']")));
        openSavedLetter.click();

        String mailDestinationAddress = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[contains(@class, 'contacts')][@data-type='to']//span"))).getText();
        String mailSubject = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@name='Subject']"))).getAttribute("value");
        String mailBody = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[contains(@id, 'BODY')]/div/div"))).getText();

        soft.assertEquals(mailDestinationAddress, DESTINATION);
        soft.assertEquals(mailSubject, SUBJECT);
        soft.assertEquals(mailBody, BODY);

        /* Sending letter */

        WebElement sendButton = driver.findElement(By.xpath("//*[@title='Отправить']"));
        sendButton.click();

        /* Verify that letter isn't in Drafts */

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Закрыть']"))).click();
        String checkDrafts = driver.findElement(By.xpath("//*[contains(@title, 'Черновики')]")).getAttribute("title");
        WebElement withoutDraftMails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='octopus__title']")));
        soft.assertEquals(withoutDraftMails.getText(), "У вас нет незаконченных\nили неотправленных писем");


        /* Verify that letter in Sent folder */
        WebElement sentFolder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Отправленные')]")));
        sentFolder.click();
        soft.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='llc__snippet']"))).getText(), BODY);

        soft.assertAll();

    }
}
