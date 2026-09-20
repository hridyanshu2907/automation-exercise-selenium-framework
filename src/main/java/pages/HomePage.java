package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By homePageLogo =
            By.cssSelector(
                    "img[alt='Website for automation practice']"
            );

    private final By signupLoginButton =
            By.cssSelector("a[href='/login']");

    private final By loggedInUser =
            By.xpath("//a[contains(.,'Logged in as')]");

    private final By deleteAccountButton =
            By.cssSelector("a[href='/delete_account']");
    
    private final By logoutButton =
            By.cssSelector("a[href='/logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageVisible() {
        return isDisplayed(homePageLogo);
    }

    public void clickSignupLogin() {
        click(signupLoginButton);
    }

    public boolean isLoggedInUserVisible(
            String expectedUsername) {

        String actualText = getText(loggedInUser);

        return actualText.contains(expectedUsername);
    }

    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }
    public void clickLogout() {
        click(logoutButton);
    }
}