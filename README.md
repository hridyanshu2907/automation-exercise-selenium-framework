# Automation Exercise Selenium Framework

A UI automation testing framework built for the [Automation Exercise](https://automationexercise.com/) website using Java, Selenium WebDriver, TestNG, Maven and the Page Object Model.

## Technology Stack

* Java 17
* Selenium WebDriver 4
* TestNG
* Maven
* Page Object Model
* Git and GitHub
* Eclipse IDE

## Current Automated Test

### Register User

The registration test performs the following actions:

1. Opens the Automation Exercise website.
2. Verifies that the home page is visible.
3. Opens the Signup/Login page.
4. Verifies the New User Signup section.
5. Enters a name and dynamically generated email address.
6. Completes the account information form.
7. Selects the newsletter and special-offer options.
8. Enters address information.
9. Creates the account.
10. Verifies the Account Created message.
11. Verifies the logged-in username.
12. Deletes the account.
13. Verifies the Account Deleted message.

A unique email address is generated during every execution to prevent duplicate-registration failures.

## Framework Features

* Page Object Model design
* Reusable base page methods
* Explicit waits
* Configuration through `config.properties`
* Chrome and Edge browser support
* TestNG assertions
* TestNG XML suite execution
* Automatic browser setup and cleanup
* JavaScript fallback for intercepted clicks
* Maven dependency management
* Unique test-data generation

## Project Structure

```text
automation-exercise-selenium-framework
├── src
│   ├── main
│   │   └── java
│   │       ├── pages
│   │       │   ├── AccountInformationPage.java
│   │       │   ├── AccountStatusPage.java
│   │       │   ├── BasePage.java
│   │       │   ├── HomePage.java
│   │       │   └── SignupLoginPage.java
│   │       └── utils
│   │           └── ConfigReader.java
│   └── test
│       ├── java
│       │   ├── base
│       │   │   └── BaseTest.java
│       │   └── tests
│       │       ├── RegisterUserTest.java
│       │       └── SetupTest.java
│       └── resources
│           └── config.properties
├── .gitignore
├── pom.xml
├── README.md
└── testng.xml
```

## Prerequisites

Install the following software before running the project:

* Java JDK 17
* Maven
* Google Chrome or Microsoft Edge
* Eclipse IDE or IntelliJ IDEA
* TestNG plugin when running through Eclipse

## Clone the Repository

```bash
git clone https://github.com/hridyanshu2907/automation-exercise-selenium-framework.git
```

Move into the project directory:

```bash
cd automation-exercise-selenium-framework
```

## Configuration

The framework configuration is stored in:

```text
src/test/resources/config.properties
```

Example configuration:

```properties
baseUrl=https://automationexercise.com/
browser=chrome
pageLoadTimeout=30
explicitWait=15
```

To run the test in Microsoft Edge, change:

```properties
browser=edge
```

## Running Through Eclipse

1. Import the project as an existing Maven project.
2. Wait for Maven to download the dependencies.
3. Right-click `testng.xml`.
4. Select **Run As → TestNG Suite**.

## Test Suite

The `testng.xml` file controls which test classes are executed:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Automation Exercise Test Suite">

    <test name="User Registration Tests">

        <classes>
            <class name="tests.RegisterUserTest"/>
        </classes>

    </test>

</suite>
```

## Future Improvements

* Screenshots when tests fail
* Extent Reports integration
* Logging with Log4j
* Data-driven testing
* Retry mechanism
* Parallel browser execution
* GitHub Actions continuous integration
* API automation with Rest Assured
* Additional login, product, cart and checkout tests

## Author

**Hridyanshu Pal**

GitHub: [hridyanshu2907](https://github.com/hridyanshu2907)
