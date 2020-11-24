package TestMailRu.Tests;

import TestMailRu.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise3Test extends BaseTest {

    @Test
    public void executeExerciseThree(){

        /* Assertion of Login */
        WebElement sendMessageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("compose-button__txt")));
        assertEquals(sendMessageButton.getText(), "Написать письмо");

        /* Creation of letter */
        sendMessageButton.click();
        WebElement addressee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-name='to'] input")));
        addressee.sendKeys(EMAIL);
        WebElement subject = driver.findElement(By.cssSelector("input[name='Subject']"));
        subject.sendKeys(SUBJECT);
        WebElement body = driver.findElement(By.cssSelector("[role='textbox']"));
        body.sendKeys(BODY);

        /* Sending letter */
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Отправить']")));
        sendButton.click();
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Закрыть']")));
        closeButton.click();

        /* Going to received folder and verify that sent letter is there */
        WebElement receivedFolder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Входящие')]")));
        receivedFolder.click();
        soft.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Andrey Purmak <testpurmakmail@mail.ru>']"))).getText(), USER);

        /* Open letter and verify content */
        WebElement draftMailBody = driver.findElement(By.xpath("//*[text()[contains(., '" + BODY + "')]]"));
        draftMailBody.click();
        String mailDestinationAddress = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='letter__author']/span"))).getAttribute("title");
        String mailSubject = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='thread__header']//h2"))).getText();
        String mailBody = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[contains(text(), 'Homework')]"))).getText();

        soft.assertEquals(mailDestinationAddress, EMAIL);
        soft.assertEquals(mailSubject, SUBJECT);
        soft.assertEquals(mailBody, BODY);

        /* Delete letter */
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Удалить']")));
        deleteButton.click();

        /* Going to Trash and verify that letter is there */
        WebElement deletedFolder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'nav__folder-name__txt') and contains(text(), 'Корзина')]")));
        deletedFolder.click();
        soft.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='llc__snippet'][1]"))).getText(), BODY);

        soft.assertAll();
    }
}
