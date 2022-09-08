package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobject.pages.GamingChairsPage;
import org.example.pageobject.pages.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class SearchResultsPageSteps {

    @Then("User observes result of filtered gaming chairs by selected brand")
    public void BrandsElementInTitle() {
        SearchResultsPage searchResultsPage = (SearchResultsPage) PAGES_STORAGE.get(SearchResultsPage.name);
        List<WebElement> searchResults = searchResultsPage.getResults();

        GamingChairsPage gamingChairsPage = (GamingChairsPage) PAGES_STORAGE.get(GamingChairsPage.name);
        String brandName = gamingChairsPage.findBrand();

        for (WebElement element : searchResults) {
            Assert.assertTrue(searchResultsPage.getBrand(element).startsWith(brandName));
        }
    }

    @Then("User observes result of filtered gaming chairs by price range")
    public void PriceVerify() {
        SearchResultsPage searchResultsPage = (SearchResultsPage) PAGES_STORAGE.get(SearchResultsPage.name);
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
        SearchResultsPage searchResultsPage = (SearchResultsPage) PAGES_STORAGE.get(SearchResultsPage.name);
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