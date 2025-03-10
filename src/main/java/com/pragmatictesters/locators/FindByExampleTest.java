package com.pragmatictesters.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindByExampleTest {

    // Locate the username field
    @FindBy(id = "username")
    private WebElement usernameField;

    // Locate the password field
    @FindBy(name = "password")
    private WebElement passwordField;

    // Locate the login button
    @FindBy(className = "login-button-class")
    private WebElement loginButton;

    // Locate the login message (success or error)
    @FindBy(tagName = "p")
    private WebElement loginMessage;

    // Locate all links within the extra-links section
    @FindBy(xpath = "//div[@class='extra-links']//a")
    private WebElement extraLinks;

    // Locate the "Forgot Password" link using text()
    @FindBy(xpath = "//a[text()='Forgot Password?']")
    private WebElement forgotPasswordLink;

    // Locate the "Sign Up" link using contains()
    @FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
    private WebElement signUpLink;

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
    public void testInvalidLogin() {
        PageFactory.initElements(driver, this);
        // Perform invalid login
        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("invalidPass");
        loginButton.click();
        Assert.assertEquals (loginMessage.getText(),"Invalid username or password.");
    }
}
