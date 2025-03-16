package com.pragmatic.selenium.support;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;


public class ByCssOrXpath extends By {
    private final By cssFinder;
    private final By xpathFinder;
    private final String cssOrXpath;

    public ByCssOrXpath(String cssOrXpath) {
        this.cssOrXpath = cssOrXpath;
        this.cssFinder = By.cssSelector(cssOrXpath);
        this.xpathFinder = By.xpath(cssOrXpath);
    }

    public WebElement findElement(SearchContext context) {
        try {
            return this.cssFinder.findElement(context);
        } catch (InvalidSelectorException var3) {
            return this.xpathFinder.findElement(context);
        }
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        List<WebElement> elements = new ArrayList<>();
        try {
            // Try finding elements with CSS selector
            elements.addAll(this.cssFinder.findElements(context));
        } catch (NoSuchElementException e) {
            // If no elements found, fall back to XPath
            System.out.println("CSS selector failed, falling back to XPath.");
            elements.addAll(this.xpathFinder.findElements(context));
        } catch (Exception e) {
            // Catch other exceptions (e.g., timeouts) and log them
            System.out.println("Error occurred during element search.");
            e.printStackTrace();
        }

        // Optionally, log if no elements were found with both locators
        if (elements.isEmpty()) {
            System.out.println("Both CSS and XPath failed to locate elements.");
        }
        return elements;
    }


    public String toString() {
        return "by CSS or XPath \"" + this.cssOrXpath + "\"";
    }
}
