package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DraftPage extends BasePage {
    public DraftPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@class='octopus__title']")
    private WebElement draftFolderIsEmpty;

    public WebElement getDraftFolderIsEmpty() {
        wait.until(ExpectedConditions.visibilityOf(draftFolderIsEmpty));
        return draftFolderIsEmpty;
    }
}
