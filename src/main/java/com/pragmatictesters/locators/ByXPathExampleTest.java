package com.pragmatictesters.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ByXPathExampleTest {

    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    public void testBasicLocators() {
        // Locating by tag
        WebElement tagElement = driver.findElement(By.xpath("//button"));
        softAssert.assertNotNull(tagElement, "Tag element is not found.");

        // Locating by single attribute
        WebElement attributeElement = driver.findElement(By.xpath("//input[@type='text']"));
        softAssert.assertNotNull(attributeElement, "Attribute element is not found.");
        attributeElement = driver.findElement(By.xpath("//*[@type='text']"));
        softAssert.assertNotNull(attributeElement, "Attribute element is not found.");


        // Locating by multiple attributes
        WebElement multipleAttributesElement = driver.findElement(By.xpath("//input[@class='username-class'][@id='username']"));
        softAssert.assertNotNull(multipleAttributesElement, "Multiple attributes element is not found.");

        multipleAttributesElement = driver.findElement(By.xpath("//input[@class='username-class' and @id='username']"));
        softAssert.assertNotNull(multipleAttributesElement, "Multiple attributes element is not found.");

        softAssert.assertAll();
    }

    @Test
    public void testAbsoluteXPath() {
        // Absolute XPath locating
        WebElement absoluteElement = driver.findElement(By.xpath("/html/body/div/div/div/a[1]"));
        softAssert.assertNotNull(absoluteElement, "Absolute XPath element is not found.");
        softAssert.assertAll();
    }


    @Test
    public void testAxisSpecificSyntaxes() {
        // Locating child elements
        WebElement childElement = driver.findElement(By.xpath("//div/child::p"));
        softAssert.assertNotNull(childElement, "Child element is not found.");
        childElement = driver.findElement(By.xpath("//div/p")); //Same as ::child
        softAssert.assertNotNull(childElement, "Child element is not found.");

        // Locating parent elements
        WebElement parentElement = driver.findElement(By.xpath("//input/parent::form"));
        softAssert.assertNotNull(parentElement, "Parent element is not found.");
        parentElement = driver.findElement(By.xpath("//input/../self::form")); //same as ::parent
        softAssert.assertNotNull(parentElement, "Parent element is not found.");

        // Locating following siblings
        WebElement followingSibling = driver.findElement(By.xpath("//label/following-sibling::input"));
        softAssert.assertNotNull(followingSibling, "Following sibling is not found.");

        //Locating following elements
        WebElement followingElement = driver.findElement(By.xpath("//input[@id='password']/following::a[4]"));
        softAssert.assertNotNull(followingElement, "Following is not found.");

        // Locating preceding siblings
        WebElement precedingSibling = driver.findElement(By.xpath("//input/preceding-sibling::label"));
        softAssert.assertNotNull(precedingSibling, "Preceding sibling is not found.");

        // Locating preceding elements
        WebElement precedingElement = driver.findElement(By.xpath("//input[@id='password']/preceding::img"));
        softAssert.assertNotNull(precedingElement, "Preceding is not found.");

        // Locating ancestors
        WebElement ancestorElement = driver.findElement(By.xpath("//button/ancestor::div[1]"));
        softAssert.assertNotNull(ancestorElement, "Ancestor element is not found.");

        // Locating descendants
        WebElement descendantElement = driver.findElement(By.xpath("//footer/descendant::a[1]"));
        softAssert.assertNotNull(descendantElement, "Descendant element is not found.");

        // Locating self
        WebElement selfElement = driver.findElement(By.xpath("//input[@name='username']/self::*"));
        softAssert.assertNotNull(selfElement, "Self element is not found.");

        softAssert.assertAll();
    }

    @Test
    public void testXPathFunctions() {
        // Locating element by text
        WebElement textElement = driver.findElement(By.xpath("//button[text()='Sign In']"));
        softAssert.assertNotNull(textElement, "Text element is not found.");

        // Locating element with contains
        WebElement containsElement = driver.findElement(By.xpath("//a[contains(@href, 'pragmatic')]"));
        softAssert.assertNotNull(containsElement, "Contains element is not found.");

        // Locating element with starts-with
        WebElement startsWithElement = driver.findElement(By.xpath("//input[starts-with(@name, 'user')]"));
        softAssert.assertNotNull(startsWithElement, "Starts-with element is not found.");

        startsWithElement = driver.findElement(By.xpath("//a[starts-with(text(), 'Sign')]"));
        softAssert.assertNotNull(startsWithElement, "Starts-with element is not found.");

        // Locating last element
        WebElement lastElement = driver.findElement(By.xpath("(//label[@class='label-class'])[last()]"));
        softAssert.assertNotNull(lastElement, "Last element is not found.");

        // Locating element by index
        WebElement indexElement = driver.findElement(By.xpath("(//label[@class='label-class'])[2]"));
        softAssert.assertNotNull(indexElement, "Indexed element is not found.");

        softAssert.assertAll();
    }

    @Test
    public void testProductPricesWithXPathOperators() {

        driver.get("https://pragmatictesters.github.io/selenium-location-strategies/product-page.html");

        // XPath to find all products with a price greater than $30
        List<WebElement> productsGreaterThan30 = driver.findElements(
                By.xpath("//section[@id='products']//div[@class='product']//p[@class='price' and number(substring-after(text(),'$')) > 30]"));

        // XPath to find all products with a price less than $50
        List<WebElement> productsLessThan50 = driver.findElements(
                By.xpath("//section[@id='products']//div[@class='product']//p[@class='price' and number(substring-after(text(),'$')) < 50]"));

        // XPath to find all products with a price exactly $39.99
        List<WebElement> productsEqualTo39 = driver.findElements(
                By.xpath("//section[@id='products']//div[@class='product']//p[@class='price' and number(substring-after(text(),'$')) = 39.99]"));

        // Assertions
        System.out.println("Number of products with price > $30: " + productsGreaterThan30.size());
        Assert.assertEquals(productsGreaterThan30.size(), 4, "There should be products with price > $30.");

        System.out.println("Number of products with price < $50: " + productsLessThan50.size());
        Assert.assertEquals(productsLessThan50.size(), 4, "There should be products with price < $50.");

        System.out.println("Number of products with price = $39.99: " + productsEqualTo39.size());
        Assert.assertEquals(productsEqualTo39.size(), 1, "There should be a product with price = $39.99.");

    }


}
