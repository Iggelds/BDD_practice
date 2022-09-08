package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {
    public static final String name = "Search results page";

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getResults() {
        return webDriver.findElements(By.xpath("//*[@data-component-type=\"s-search-result\"]"));
    }

    public String getBrand(WebElement element) {
        return element.findElement(By.tagName("h2")).getText().toLowerCase();
    }

    public Double wholePrice(WebElement element) {
        WebElement whole, fraction;
        try {
            whole = element.findElement(By.className("a-price-whole"));
            fraction = element.findElement(By.className("a-price-fraction"));
        }catch (NoSuchElementException e) {
            return null;
        }
        String result = whole.getText() + "." + fraction.getText();
        return Double.parseDouble(result);
    }
}
