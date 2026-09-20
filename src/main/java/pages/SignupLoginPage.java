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
    private final By loginHeading =
            By.xpath("//h2[text()='Login to your account']");

    private final By loginEmailField =
            By.cssSelector("input[data-qa='login-email']");

    private final By loginPasswordField =
            By.cssSelector("input[data-qa='login-password']");

    private final By loginButton =
            By.cssSelector("button[data-qa='login-button']");
    
    
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
    
    public boolean isLoginHeadingVisible() {
        return isDisplayed(loginHeading);
    }

    public void enterLoginEmail(String email) {
        type(loginEmailField, email);
    }

    public void enterLoginPassword(String password) {
        type(loginPasswordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void loginUser(String email, String password) {

        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLoginButton();
    }
}