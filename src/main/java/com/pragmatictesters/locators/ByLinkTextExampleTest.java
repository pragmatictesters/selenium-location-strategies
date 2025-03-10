package com.pragmatictesters.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ByLinkTextExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
    }


    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testForgotPasswordLink() {
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        Assert.assertTrue(forgotPasswordLink.isDisplayed(), "Forgot Password link is not displayed.");
        forgotPasswordLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("forgot-password.html"), "Navigation to forgot password page failed.");
    }

    @Test
    public void testSignUpLink() {
        WebElement signUpLink = driver.findElement(By.linkText("Sign Up"));
        Assert.assertTrue(signUpLink.isDisplayed(), "Sign Up link is not displayed.");
        signUpLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("signup.html"), "Navigation to sign up page failed.");
    }


}
