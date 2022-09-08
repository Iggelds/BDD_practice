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
        GamingChairsPage gamingChairsPage = new GamingChairsPage(webDriver);
        gamingChairsPage.open();

        PAGES_STORAGE.put(pageName, gamingChairsPage);
    }

    @When("User enters username as {string} and password on {string}")
    public void userEntersUsernameAndPassword (String login, String pageName) {
//        SearchResultsPage searchResultsPage = (SearchResultsPage) PAGES_STORAGE.get(pageName);
//        GamingChairsPage gamingChairsPage = searchResultsPage.login(login, "cAro-Kann0");
//
//        PAGES_STORAGE.put("Home Page", gamingChairsPage);
    }
}
