package com.pragmatictesters.locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RelativeLocatorsExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRelativeLocators() {
        // Locate the "Password" label using relative locator (above the password field)
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(RelativeLocator.with(By.tagName("label")).above(passwordField));
        Assert.assertEquals(passwordLabel.getText(), "Password:", "Password label text mismatch");

        // Locate the "Username" label using relative locator (above the username field)
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(RelativeLocator.with(By.tagName("label")).above(usernameField));
        Assert.assertEquals(usernameLabel.getText(), "Username:", "Username label text mismatch");

        // Locate the "Sign In" button using relative locator (below the password field)
        WebElement signInButton = driver.findElement(RelativeLocator.with(By.tagName("button")).below(passwordField));
        Assert.assertEquals(signInButton.getText(), "Sign In", "Sign In button text mismatch");

        // Locate the "Forgot Password?" link using relative locator (near the Sign In button)
        WebElement forgotPasswordLink = driver.findElement(RelativeLocator.with(By.tagName("a")).near(signInButton));
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?", "Forgot Password link text mismatch");

        // Locate the "Home" link in the footer (to right of "Contact")
        WebElement contactLink = driver.findElement(By.xpath("//a[text()='Contact']"));
        WebElement homeLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(contactLink));
        Assert.assertEquals(homeLink.getText(), "About", "Home link text mismatch");

        // Locate the "Contact" link in the footer (to left of "About")
        WebElement aboutLink = driver.findElement(By.xpath("//a[text()='About']"));
        WebElement contactLinkLeft = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(aboutLink));
        Assert.assertEquals(contactLinkLeft.getText(), "Contact", "Contact link text mismatch");
    }


}
