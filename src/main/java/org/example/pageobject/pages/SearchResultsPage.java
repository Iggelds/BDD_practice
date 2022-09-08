package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "commit")
    private WebElement sighInButton;

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchResultsPage open() {
        webDriver.get("https://www.github.com/login");
        return this;
    }

    public GamingChairsPage login(String username, String pass) {
        loginField.sendKeys(username);
        passwordField.sendKeys(pass);
        sighInButton.click();

        return new GamingChairsPage(webDriver);
    }

    public void fillIncorrectData(String username, String pass) {
        loginField.sendKeys(username);
        passwordField.sendKeys(pass);
    }

    public String clickSighInButtonAndReceiveErrorMessage() {
        sighInButton.click();
        return webDriver.findElement(By.id("js-flash-container")).getText();
    }

}
