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

public class ByClassNameExampleTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
        driver.manage().window().maximize();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginUsingClassName() {
        // Locate username field by class name and enter a valid username
        WebElement usernameInput = driver.findElement(By.className("username-class"));
        usernameInput.sendKeys("pragmatic");

        // Locate password field by class name and enter a valid password
        WebElement passwordInput = driver.findElement(By.className("password-class"));
        passwordInput.sendKeys("secret");

        // Locate login button by class name and click
        WebElement loginButton = driver.findElement(By.className("login-button-class"));
        loginButton.click();

        // Assert that the user is redirected to the product page
        WebElement productPageHeader = driver.findElement(By.id("products"));
        Assert.assertTrue(productPageHeader.isDisplayed(), "Login failed or product page not loaded.");
    }


}
