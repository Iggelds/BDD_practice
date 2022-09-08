package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobject.pages.GamingChairsPage;
import org.example.pageobject.pages.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.example.stepdefinitions.BaseSteps.webDriver;

public class SearchResultsPageSteps {

    @Then("User observes result of filtered gaming chairs by selected brand")
    public void BrandsElementInTitle() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
        List<WebElement> searchResults = searchResultsPage.getResults();
        String brandName = GamingChairsPage.findBrand();

        for (WebElement element : searchResults) {
            Assert.assertTrue(searchResultsPage.getBrand(element).startsWith(brandName));
        }
    }

    @Then("User observes result of filtered gaming chairs by price range")
    public void PriceVerify() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
        List<WebElement> searchResults = searchResultsPage.getResults();

        for (WebElement element : searchResults) {
            Double price = searchResultsPage.wholePrice(element);
            if (price != null) {
                double delta = 0.01;
                Assert.assertTrue(price >= 100.00 - delta);
                Assert.assertTrue(price <= 150.00 + delta);
            }
        }
    }

    @Then("User observes result of sorted gaming chairs")
    public void PriceSorting() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
        List<WebElement> searchResults = searchResultsPage.getResults();
        double price = 0.00;

        for (WebElement element : searchResults) {
            Double currentPrice = searchResultsPage.wholePrice(element);
            if (currentPrice != null) {
                Assert.assertTrue(currentPrice >= price);
                price = currentPrice;
            }
        }
    }
}