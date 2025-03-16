package com.pragmatictesters.locators;

import com.pragmatic.selenium.support.ByCssOrXpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ByCssOrXpathExampleTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        String demoURL = "https://pragmatictesters.github.io/selenium-location-strategies/index.html";
        driver.get(demoURL);
        driver.manage().window().maximize();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginUsingIdOrNameLocationStrategy() {
        // Locate username field by ID and enter a valid username
        WebElement usernameInput = driver.findElement(new ByCssOrXpath("#username"));
        usernameInput.sendKeys("pragmatic");

        // Locate password field by ID and enter a valid password
        WebElement passwordInput = driver.findElement(new ByCssOrXpath("//input[@name='password']"));
        passwordInput.sendKeys("secret");

        // Locate login button by ID and click
        WebElement loginButton = driver.findElement(new ByCssOrXpath("//*[@id='loginButton']"));
        loginButton.click();

        // Assert that the user is redirected to the product page
        WebElement productPageHeader = driver.findElement(new ByCssOrXpath("#products"));
        Assert.assertTrue(productPageHeader.isDisplayed(), "Login failed or product page not loaded.");
    }
}
