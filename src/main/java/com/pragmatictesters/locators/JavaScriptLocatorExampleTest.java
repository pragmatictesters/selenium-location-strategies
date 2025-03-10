package com.pragmatictesters.locators;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptLocatorExampleTest {

    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testInvalidLoginUsingJavaScriptLocators() {
        // Locate username field using ID and enter invalid username
        js.executeScript("document.getElementById('username').value = 'invalidUser';");

        // Locate password field using class name and enter invalid password
        js.executeScript("document.getElementsByClassName('password-class')[0].value = 'wrongPass';");

        // Locate login button using CSS selector and click
        js.executeScript("document.querySelector('.login-button-class').click();");

        // Assertion for error message using tag name
        WebElement loginMessage = (WebElement) js.executeScript("return document.getElementsByTagName('p')[0];");
        String messageText = loginMessage.getText();
        Assert.assertEquals(messageText, "Invalid username or password.");
    }


}
