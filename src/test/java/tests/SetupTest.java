package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SetupTest extends BaseTest {

    @Test
    public void verifyWebsiteOpens() {

        String actualTitle = driver.getTitle();

        System.out.println("Page title: " + actualTitle);

        Assert.assertTrue(
                actualTitle.contains("Automation Exercise"),
                "The Automation Exercise website did not open."
        );
    }
}