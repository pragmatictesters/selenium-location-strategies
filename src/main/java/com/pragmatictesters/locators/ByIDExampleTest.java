package com.pragmatictesters.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ByIDExampleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        String demoURL = "https://pragmatictesters.github.io/selenium-location-strategies/index.html";
        driver.get(demoURL);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginUsingID() {
        // Locate username field by ID and enter a valid username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("pragmatic");

        // Locate password field by ID and enter a valid password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret");

        // Locate login button by ID and click
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Assert that the user is redirected to the product page
        WebElement productPageHeader = driver.findElement(By.id("products"));
        Assert.assertTrue(productPageHeader.isDisplayed(), "Login failed or product page not loaded.");
    }


}
