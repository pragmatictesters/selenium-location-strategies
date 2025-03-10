package com.pragmatictesters.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindAllExampleTest {

    private WebDriver driver;

    @FindAll({
            @FindBy(tagName = "input"),
            @FindBy(className = "btn__primary--large"),
            @FindBy(css = "a.nav-link"),
            @FindBy(xpath = "//p")
    })
    private List<WebElement> allElements;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/index.html");
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test
    public void testFindAllElements() {
        Assert.assertFalse(allElements.isEmpty(), "Expected at least one element to be found using FindAll.");

        int inputCount = 0;
        int buttonCount = 0;
        int linkCount = 0;
        int paragraphs = 0;

        for (WebElement element : allElements) {
            String tagName = element.getTagName();
            switch (tagName) {
                case "input":
                    inputCount++;
                    break;
                case "button":
                    buttonCount++;
                    break;
                case "a":
                    linkCount++;
                    break;
                case "p":
                        paragraphs++;
                    break;
                default:
                    System.out.println("Other element found: " + tagName);
                    break;
            }
        }

        Assert.assertEquals(inputCount, 2, "Number of input elements mismatch");
        Assert.assertEquals(buttonCount, 1, "Number of button elements mismatch");
        Assert.assertEquals(linkCount, 3, "Number of link elements mismatch");
        Assert.assertEquals(paragraphs, 1, "Number of p elements mismatch");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
