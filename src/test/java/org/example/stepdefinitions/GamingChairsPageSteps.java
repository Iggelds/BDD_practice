package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.GamingChairsPage;
import org.example.pageobject.pages.SearchResultsPage;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.stepdefinitions.BaseSteps.webDriver;


public class GamingChairsPageSteps {
    @Given("User is on {string}")
    public void userIsOnPage(String pageName) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
        searchResultsPage.open();

//        PAGES_STORAGE.put(pageName, searchResultsPage);
    }

    @When("User clicks on brand name inside the filter")
    public void userChoosesBrand() {
        GamingChairsPage gamingChairsPage = new GamingChairsPage(webDriver);
        gamingChairsPage.filterByBrand();

//        PAGES_STORAGE.put("Home Page", gamingChairsPage);
    }

    @When("User selects the range between minimum and maximum price and executes the filter")
    public void userSelectsPriceRange() {
        GamingChairsPage gamingChairsPage = new GamingChairsPage(webDriver);
        gamingChairsPage.filterByPrice(100.00, 150.00);

//        PAGES_STORAGE.put("Home Page", gamingChairsPage);
    }

    @When("User clicks dropdown menu and selects price from low to high")
    public void userSelectsSortingPrice() {
        GamingChairsPage gamingChairsPage = new GamingChairsPage(webDriver);
        gamingChairsPage.sortingByLowToHighPrice();

    }
}
