package com.pragmatictesters.locators;

import com.pragmatic.selenium.support.ByAttributeValue;
import com.pragmatic.selenium.support.ByPartialText;
import com.pragmatic.selenium.support.ByText;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomLocatorExampleTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://pragmatictesters.github.io/selenium-location-strategies/javascript-popups.html");

    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        webDriver.close();
    }

    @Test
    public void testLocateElementByAttributeAndValue() {
        // Locate the first checkbox
        WebElement eleTextBox = webDriver.findElement(new ByAttributeValue("id", "nameInput"));
        Assert.assertEquals(eleTextBox.getDomProperty("placeholder"), "John Doe");
    }


    @Test
    public void testLocateElementsByText(){
        webDriver.findElement(new ByText("Show Alert")).click();
        Alert alert = webDriver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "This is a simple alert!");
        alert.accept(); //Clicking OK button in the alert
    }


    @Test
    public void testLocateElementsByPartialText(){

        webDriver.findElement(new ByPartialText("Alert")).click();
        Alert alert = webDriver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "This is a simple alert!");
        alert.accept(); //Clicking OK button in the alert
    }

}
