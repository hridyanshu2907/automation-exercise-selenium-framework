package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementClickInterceptedException;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    protected WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    protected void click(By locator) {

        WebElement element = waitForClickable(locator);

        JavascriptExecutor javascriptExecutor =
                (JavascriptExecutor) driver;

        javascriptExecutor.executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );

        try {
            element.click();

        } catch (ElementClickInterceptedException exception) {

            javascriptExecutor.executeScript(
                    "arguments[0].click();",
                    element
            );
        }
    }

    protected void type(By locator, String value) {

        WebElement element = waitForVisibility(locator);

        element.clear();
        element.sendKeys(value);
    }

    protected String getText(By locator) {

        return waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        try {
            return waitForVisibility(locator).isDisplayed();

        } catch (Exception exception) {
            return false;
        }
    }

    protected void selectByVisibleText(
            By locator,
            String visibleText) {

        WebElement dropdown = waitForVisibility(locator);

        Select select = new Select(dropdown);

        select.selectByVisibleText(visibleText);
    }
    protected void clickUsingJavaScript(By locator) {

        WebElement element = waitForVisibility(locator);

        JavascriptExecutor javascriptExecutor =
                (JavascriptExecutor) driver;

        javascriptExecutor.executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );

        javascriptExecutor.executeScript(
                "arguments[0].click();",
                element
        );
    }
}