package TestMailRu.Tests;

import TestMailRu.BaseTest;
import org.testng.annotations.Test;

import static config.TestDataConstants.*;
import static org.testng.Assert.assertEquals;

public class Exercise2Test extends BaseTest {

    @Test
    public void runExerciseTwo() {
        assertEquals(mailPage.createNewLetterButton().getText(), "Написать письмо");
        mailPage.writeLetter();

        createLetterPage.writeLetterForMyselfForTestFolder();
        createLetterPage.sendLetter();
        createLetterPage.closeLetter();

        mailPage.goToSentFolder();
        soft.assertEquals(openedLetterPage.getLetterForMyself().getText(), EMAIL);

        mailPage.goToTestFolder();
        soft.assertEquals(openedLetterPage.getLetterForMyselfInInboxFolder().getText(), USER);

        openedLetterPage.openLetterForMyselfInInboxFolder();
        soft.assertEquals(openedLetterPage.getLetterForMyself().getAttribute("title"), EMAIL);
        soft.assertEquals(openedLetterPage.getSubjectFieldInOpenedLetter().getText(), SUBJECT_TEST);
        soft.assertEquals(openedLetterPage.getBodyField().getText(), BODY);

        soft.assertAll();
    }
}
