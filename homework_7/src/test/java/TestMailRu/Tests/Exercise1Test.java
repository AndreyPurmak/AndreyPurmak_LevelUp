package TestMailRu.Tests;

import TestMailRu.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static config.TestDataConstants.*;
import static org.testng.Assert.assertEquals;

public class Exercise1Test extends BaseTest {

    @Test
    public void runExerciseOne() {
        assertEquals(mailPage.createNewLetterButton().getText(), "Написать письмо");
        mailPage.writeLetter();

        createLetterPage.writeLetterForExerciseOne();
        createLetterPage.saveLetter();
        createLetterPage.closeLetter();

        mailPage.goToDraftFolder();
        soft.assertTrue(wait.until(ExpectedConditions.titleIs("Черновики - Почта Mail.ru")));
        openedLetterPage.openLetterForAddressee();

        soft.assertEquals(openedLetterPage.getAddresseeField().getText(), DESTINATION);
        soft.assertEquals(openedLetterPage.getSubjectField().getAttribute("value"), SUBJECT);
        soft.assertEquals(openedLetterPage.getBodyField().getText(), BODY);

        createLetterPage.sendLetter();
        createLetterPage.closeLetter();

        soft.assertEquals(draftPage.getDraftFolderIsEmpty().getText(), "У вас нет незаконченных\nили неотправленных писем");

        mailPage.goToSentFolder();
        openedLetterPage.openLetterForAddressee();
        soft.assertEquals(openedLetterPage.getBodyField().getText(), BODY);

        soft.assertAll();
    }

}
