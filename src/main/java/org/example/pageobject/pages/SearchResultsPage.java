package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {
    private final List<WebElement> searchResults =
            webDriver.findElements(By.xpath("//*[@data-component-type=\"s-search-result\"]"));

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

//    public SearchResultsPage open() {
//        webDriver.get("https://www.github.com/login");
//        return this;
//    }

    public List<WebElement> getResults() {
        return searchResults;
    }

    public String getBrand(WebElement element) {
        return element.findElement(By.tagName("h2")).getText().toLowerCase();
    }

    public Double wholePrice(WebElement element) {
        WebElement whole = element.findElement(By.className("a-price-whole"));
        WebElement fraction = element.findElement(By.className("a-price-fraction"));
        if (whole == null || fraction == null) {
            return null;
        }
        String result = whole.getText() + "." + fraction.getText();
        return Double.parseDouble(result);
    }
}
