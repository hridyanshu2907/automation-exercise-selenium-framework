package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountInformationPage;
import pages.AccountStatusPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void verifyUserCanRegisterSuccessfully() {

        String username = "Hridyanshu";

        String uniqueEmail =
                "hridyanshu"
                + System.currentTimeMillis()
                + "@gmail.com";

        // Step 3: Verify that the home page is visible
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageVisible(),
                "Home page is not visible."
        );

        // Step 4: Click Signup/Login
        homePage.clickSignupLogin();

        // Step 5: Verify New User Signup is visible
        SignupLoginPage signupLoginPage =
                new SignupLoginPage(driver);

        Assert.assertTrue(
                signupLoginPage.isNewUserSignupVisible(),
                "New User Signup section is not visible."
        );

        // Steps 6 and 7: Enter name/email and click Signup
        signupLoginPage.signupUser(
                username,
                uniqueEmail
        );

        // Step 8: Verify account information page
        AccountInformationPage accountInformationPage =
                new AccountInformationPage(driver);

        Assert.assertTrue(
                accountInformationPage
                        .isAccountInformationVisible(),
                "Account information page is not visible."
        );

        // Step 9: Enter basic account information
        accountInformationPage.selectTitleMr();

        accountInformationPage.enterPassword(
                "Password@123"
        );

        accountInformationPage.selectDateOfBirth(
                "10",
                "January",
                "2000"
        );

        // Steps 10 and 11: Select checkboxes
        accountInformationPage.selectNewsletter();
        accountInformationPage.selectSpecialOffers();

        // Step 12: Enter address information
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

        // Step 13: Click Create Account
        accountInformationPage.clickCreateAccount();

        AccountStatusPage accountStatusPage =
                new AccountStatusPage(driver);

        // Step 14: Verify Account Created
        Assert.assertTrue(
                accountStatusPage.isAccountCreatedVisible(),
                "Account Created message is not visible."
        );

        // Step 15: Click Continue
        accountStatusPage.clickContinue();

        // Step 16: Verify Logged in as username
        Assert.assertTrue(
                homePage.isLoggedInUserVisible(username),
                "Logged-in username is not visible."
        );

        // Step 17: Click Delete Account
        homePage.clickDeleteAccount();

        // Step 18: Verify Account Deleted
        Assert.assertTrue(
                accountStatusPage.isAccountDeletedVisible(),
                "Account Deleted message is not visible."
        );

        accountStatusPage.clickContinue();
    }
}