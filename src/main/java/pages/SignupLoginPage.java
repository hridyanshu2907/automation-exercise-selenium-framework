package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {

    private final By newUserSignupHeading =
            By.xpath("//h2[text()='New User Signup!']");

    private final By signupNameField =
            By.cssSelector("input[data-qa='signup-name']");

    private final By signupEmailField =
            By.cssSelector("input[data-qa='signup-email']");

    private final By signupButton =
            By.cssSelector("button[data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewUserSignupVisible() {
        return isDisplayed(newUserSignupHeading);
    }

    public void enterSignupName(String name) {
        type(signupNameField, name);
    }

    public void enterSignupEmail(String email) {
        type(signupEmailField, email);
    }

    public void clickSignupButton() {
        click(signupButton);
    }

    public void signupUser(String name, String email) {

        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }
}