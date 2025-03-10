package com.pragmatictesters.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ByCSSExampleTest {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
    }

    @Test
    public void testCSSSelectors() {
        // ID Selector
        WebElement idElement = driver.findElement(By.cssSelector("#username"));
        softAssert.assertTrue(idElement.isDisplayed(), "ID selector failed");

        // Dynamic CSS Construction (e.g., by ID)
        String dynamicId = "username";
        WebElement dynamicElement = driver.findElement(By.cssSelector("#" + dynamicId));
        softAssert.assertTrue(dynamicElement.isDisplayed(), "Dynamic ID selector failed");

        // Tag Name Selector
        WebElement tagElement = driver.findElement(By.cssSelector("button"));
        softAssert.assertTrue(tagElement.isDisplayed(), "Tag name selector failed");

        // Class Selector
        WebElement classElement = driver.findElement(By.cssSelector(".login-button-class"));
        softAssert.assertTrue(classElement.isDisplayed(), "Class selector failed");

        // Multiple Class Selector
        WebElement multiClassElement = driver.findElement(By.cssSelector(".btn__primary--large.login-button-class"));
        softAssert.assertTrue(multiClassElement.isDisplayed(), "Multiple class selector failed");

        // Class with ID
        WebElement classWithIdElement = driver.findElement(By.cssSelector("#username.username-class"));
        softAssert.assertTrue(classWithIdElement.isDisplayed(), "Class with ID selector failed");

        // Attribute Selector
        WebElement attrElement = driver.findElement(By.cssSelector("input[type='text']"));
        softAssert.assertTrue(attrElement.isDisplayed(), "Attribute selector failed");

        // Multiple Attribute Selector (AND)
        WebElement multiAttrElement = driver.findElement(By.cssSelector("input[type='password'][name='password']"));
        softAssert.assertTrue(multiAttrElement.isDisplayed(), "Multiple attribute selector (AND) failed");

        // Combining Classes and Attributes (AND)
        WebElement classAttrElement = driver.findElement(By.cssSelector("input.username-class[type='text']"));
        softAssert.assertTrue(classAttrElement.isDisplayed(), "Class and attribute (AND) selector failed");

        // Starts with (^) Selector
        WebElement startsWithElement = driver.findElement(By.cssSelector("[id^='user']"));
        softAssert.assertTrue(startsWithElement.isDisplayed(), "Starts with selector failed");

        // Ends with ($) Selector
        WebElement endsWithElement = driver.findElement(By.cssSelector("[id$='name']"));
        softAssert.assertTrue(endsWithElement.isDisplayed(), "Ends with selector failed");

        // Contains (*) Selector
        WebElement containsElement = driver.findElement(By.cssSelector("[id*='ser']"));
        softAssert.assertTrue(containsElement.isDisplayed(), "Contains selector failed");

        // Case Insensitive (i) Selector
        WebElement caseInsensitiveElement = driver.findElement(By.cssSelector("[id='USERNAME' i]"));
        softAssert.assertTrue(caseInsensitiveElement.isDisplayed(), "Case-insensitive selector failed");

        // Descendant Selector
        WebElement descendantElement = driver.findElement(By.cssSelector("div.login-container input.username-class"));
        softAssert.assertTrue(descendantElement.isDisplayed(), "Descendant selector failed");

        // nth-of-type Selector
        WebElement nthTypeElement = driver.findElement(By.cssSelector("input:nth-of-type(1)"));
        softAssert.assertTrue(nthTypeElement.isDisplayed(), "nth-of-type selector failed");

        // first-of-type Selector
        WebElement firstOfTypeElement = driver.findElement(By.cssSelector("input:first-of-type"));
        softAssert.assertTrue(firstOfTypeElement.isDisplayed(), "first-of-type selector failed");

        // last-of-type Selector
        WebElement lastOfTypeElement = driver.findElement(By.cssSelector("input:last-of-type"));
        softAssert.assertTrue(lastOfTypeElement.isDisplayed(), "last-of-type selector failed");

        // Following Sibling Selector
        WebElement followingSiblingElement = driver.findElement(By.cssSelector("label + input.username-class"));
        softAssert.assertTrue(followingSiblingElement.isDisplayed(), "Following sibling selector failed");

        // Assert all
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}