package com.pragmatictesters.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindBysExampleTest {

    private WebDriver driver;

    @FindBys({
            @FindBy(tagName = "div"),
            @FindBy(className = "product"),
            @FindBy(xpath = ".//p[@class='price']")
    })
    private List<WebElement> productPrices;

    @FindBys({
            @FindBy(tagName = "div"),
            @FindBy(className = "product"),
            @FindBy(xpath = ".//h3")
    })
    private List<WebElement> productNames;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/product-page.html");
        PageFactory.initElements(driver, this);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFindBysProducts() {
        Assert.assertFalse(productPrices.isEmpty(), "No products found with the specified criteria.");
        Assert.assertFalse(productNames.isEmpty(), "No product names found with the specified criteria.");

        Assert.assertEquals(productPrices.size(), productNames.size(), "Product names and prices count mismatch.");

        for (int i = 0; i < productNames.size(); i++) {
            String productName = productNames.get(i).getText();
            String productPrice = productPrices.get(i).getText();
            System.out.println("Product: " + productName + " | Price: " + productPrice);

            // Verifying that the product price starts with a dollar sign
            Assert.assertTrue(productPrice.startsWith("$"), "Price format mismatch for: " + productName);
        }
    }


}

