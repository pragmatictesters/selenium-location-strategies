package com.pragmatictesters.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class ByTagNameExampleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
    }

    @AfterClass (alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginUsingTagName() {
        // Locate username field by tag name and enter a valid username
        WebElement usernameInput = driver.findElement(By.tagName("input"));
        usernameInput.sendKeys("pragmatic");

        // Locate password field by tag name and enter a valid password
        WebElement passwordInput = driver.findElements(By.tagName("input")).get(1);
        passwordInput.sendKeys("secret");

        // Locate login button by tag name and click
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // Assert that the user is redirected to the product page
        WebElement productPageHeader = driver.findElement(By.id("products"));
        Assert.assertTrue(productPageHeader.isDisplayed(), "Login failed or product page not loaded.");
    }


}
