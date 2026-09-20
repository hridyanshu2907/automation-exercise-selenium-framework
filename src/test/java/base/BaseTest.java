package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String browser =
                ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        driver.manage().window().maximize();

        int pageLoadTimeout = Integer.parseInt(
                ConfigReader.getProperty("pageLoadTimeout")
        );

        driver.manage()
              .timeouts()
              .pageLoadTimeout(
                      Duration.ofSeconds(pageLoadTimeout)
              );

        driver.get(
                ConfigReader.getProperty("baseUrl")
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}