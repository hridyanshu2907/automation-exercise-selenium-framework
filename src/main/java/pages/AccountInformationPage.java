package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountInformationPage extends BasePage {

    private final By accountInformationHeading =
            By.xpath("//b[text()='Enter Account Information']");

    private final By titleMrRadioButton =
            By.id("id_gender1");

    private final By passwordField =
            By.id("password");

    private final By dayDropdown =
            By.id("days");

    private final By monthDropdown =
            By.id("months");

    private final By yearDropdown =
            By.id("years");

    private final By newsletterCheckbox =
            By.cssSelector("label[for='newsletter']");

    private final By specialOffersCheckbox =
            By.cssSelector("label[for='optin']");

    private final By firstNameField =
            By.id("first_name");

    private final By lastNameField =
            By.id("last_name");

    private final By companyField =
            By.id("company");

    private final By addressOneField =
            By.id("address1");

    private final By addressTwoField =
            By.id("address2");

    private final By countryDropdown =
            By.id("country");

    private final By stateField =
            By.id("state");

    private final By cityField =
            By.id("city");

    private final By zipcodeField =
            By.id("zipcode");

    private final By mobileNumberField =
            By.id("mobile_number");

    private final By createAccountButton =
            By.cssSelector("button[data-qa='create-account']");

    public AccountInformationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountInformationVisible() {
        return isDisplayed(accountInformationHeading);
    }

    public void selectTitleMr() {
        click(titleMrRadioButton);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void selectDateOfBirth(
            String day,
            String month,
            String year) {

        selectByVisibleText(dayDropdown, day);
        selectByVisibleText(monthDropdown, month);
        selectByVisibleText(yearDropdown, year);
    }

    public void selectNewsletter() {
        clickUsingJavaScript(newsletterCheckbox);
    }

    public void selectSpecialOffers() {
        clickUsingJavaScript(specialOffersCheckbox);
    }

    public void enterAddressInformation(
            String firstName,
            String lastName,
            String company,
            String addressOne,
            String addressTwo,
            String country,
            String state,
            String city,
            String zipcode,
            String mobileNumber) {

        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(companyField, company);
        type(addressOneField, addressOne);
        type(addressTwoField, addressTwo);

        selectByVisibleText(countryDropdown, country);

        type(stateField, state);
        type(cityField, city);
        type(zipcodeField, zipcode);
        type(mobileNumberField, mobileNumber);
    }

    public void clickCreateAccount() {
        click(createAccountButton);
    }
}