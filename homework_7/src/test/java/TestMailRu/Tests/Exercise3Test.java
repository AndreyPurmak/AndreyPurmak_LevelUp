package TestMailRu.Tests;

import TestMailRu.BaseTest;
import org.testng.annotations.Test;

import static config.TestDataConstants.*;
import static org.testng.Assert.assertEquals;

public class Exercise3Test extends BaseTest {

    @Test
    public void runExerciseThree() {
        assertEquals(mailPage.createNewLetterButton().getText(), "Написать письмо");
        mailPage.writeLetter();

        createLetterPage.writeLetterForMyself();
        createLetterPage.sendLetter();
        createLetterPage.closeLetter();

        mailPage.goToInboxFolder();
        soft.assertEquals(openedLetterPage.getLetterForMyselfInInboxFolder().getText(), USER);

        openedLetterPage.openLetterForMyselfInInboxFolder();
        soft.assertEquals(openedLetterPage.getLetterForMyself().getAttribute("title"), EMAIL);
        soft.assertEquals(openedLetterPage.getSubjectFieldInOpenedLetter().getText(), SUBJECT);
        soft.assertEquals(openedLetterPage.getBodyField().getText(), BODY);

        openedLetterPage.deleteLetter();

        mailPage.goToTrashFolder();
        soft.assertEquals(openedLetterPage.getLetterForMyselfInInboxFolder().getText(), USER);

        soft.assertAll();
    }
}

