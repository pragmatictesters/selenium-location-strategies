package com.pragmatictesters.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ByPartialLinkTextExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
    }

    @Test
    public void testPartialLinkText() {
        // Locate the link using partial link text
        WebElement link = driver.findElement(By.partialLinkText("Forgot"));

        // Verify the link text and click the link
        Assert.assertTrue(link.isDisplayed(), "Forgot Password link should be displayed.");
        link.click();

        // Verify the navigation to the forgot password page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("forgot-password"), "Navigation to Forgot Password page failed.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
