package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountInformationPage;
import pages.AccountStatusPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class LoginUserTest extends BaseTest {

    @Test
    public void verifyLoginWithCorrectCredentials() {

        String username = "Hridyanshu";
        String password = "Password@123";

        String uniqueEmail =
                "hridyanshu"
                + System.currentTimeMillis()
                + "@gmail.com";

        HomePage homePage = new HomePage(driver);

        SignupLoginPage signupLoginPage =
                new SignupLoginPage(driver);

        AccountInformationPage accountInformationPage =
                new AccountInformationPage(driver);

        AccountStatusPage accountStatusPage =
                new AccountStatusPage(driver);

        /*
         * PRECONDITION
         * Create an account that can be used for login.
         */

        Assert.assertTrue(
                homePage.isHomePageVisible(),
                "Home page is not visible."
        );

        homePage.clickSignupLogin();

        Assert.assertTrue(
                signupLoginPage.isNewUserSignupVisible(),
                "New User Signup section is not visible."
        );

        signupLoginPage.signupUser(
                username,
                uniqueEmail
        );

        Assert.assertTrue(
                accountInformationPage
                        .isAccountInformationVisible(),
                "Account information page is not visible."
        );

        accountInformationPage.selectTitleMr();
        accountInformationPage.enterPassword(password);

        accountInformationPage.selectDateOfBirth(
                "10",
                "January",
                "2000"
        );

        accountInformationPage.selectNewsletter();
        accountInformationPage.selectSpecialOffers();

        accountInformationPage.enterAddressInformation(
                "Hridyanshu",
                "Pal",
                "Test Company",
                "123 Test Street",
                "Near Metro Station",
                "India",
                "Delhi",
                "New Delhi",
                "110001",
                "9876543210"
        );

        accountInformationPage.clickCreateAccount();

        Assert.assertTrue(
                accountStatusPage.isAccountCreatedVisible(),
                "Account was not created."
        );

        accountStatusPage.clickContinue();

        Assert.assertTrue(
                homePage.isLoggedInUserVisible(username),
                "User was not logged in after registration."
        );

        // Log out so we can test logging in again
        homePage.clickLogout();

        /*
         * ACTUAL TEST CASE 2
         */

        // Step 5: Verify Login to your account is visible
        Assert.assertTrue(
                signupLoginPage.isLoginHeadingVisible(),
                "Login to your account is not visible."
        );

        // Steps 6 and 7: Enter credentials and click Login
        signupLoginPage.loginUser(
                uniqueEmail,
                password
        );

        // Step 8: Verify Logged in as username
        Assert.assertTrue(
                homePage.isLoggedInUserVisible(username),
                "User was not logged in successfully."
        );

        // Step 9: Delete account
        homePage.clickDeleteAccount();

        // Step 10: Verify Account Deleted
        Assert.assertTrue(
                accountStatusPage.isAccountDeletedVisible(),
                "Account Deleted message is not visible."
        );

        accountStatusPage.clickContinue();
    }
}