package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountStatusPage extends BasePage {

    private final By accountCreatedMessage =
            By.cssSelector("h2[data-qa='account-created']");

    private final By accountDeletedMessage =
            By.cssSelector("h2[data-qa='account-deleted']");

    private final By continueButton =
            By.cssSelector("a[data-qa='continue-button']");

    public AccountStatusPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedVisible() {
        return isDisplayed(accountCreatedMessage);
    }

    public boolean isAccountDeletedVisible() {
        return isDisplayed(accountDeletedMessage);
    }

    public void clickContinue() {
        click(continueButton);
    }
}