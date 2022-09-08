package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamingChairsPage extends BasePage {
    public static final String name = "Gaming chairs page";
    @FindBy(xpath = "(//*[@id=\"brandsRefinements\"]//li)[2]")
    private WebElement brandLi;

    @FindBy(xpath = "//*[@id=\"low-price\"]")
    private WebElement low_price;

    @FindBy(xpath = "//*[@id=\"high-price\"]")
    private WebElement high_price;

    @FindBy(xpath = "//*[@id=\"priceRefinements\"]//form")
    private WebElement submitForm;

    @FindBy(xpath = "//*[@class=\"a-dropdown-prompt\"]")
    private WebElement dropDownPrompt;

    @FindBy(xpath = "//*[@id=\"s-result-sort-select_1\"]")
    private WebElement sort_select;

    public GamingChairsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        webDriver.get("https://www.amazon.com/s?k=gaming+chairs");
    }

    public SearchResultsPage filterByBrand() {
        WebElement brandInput = brandLi.findElement(By.tagName("input"));
        brandInput.sendKeys(Keys.SPACE);
        return new SearchResultsPage(webDriver);
    }

    public String findBrand() {
        String label = brandLi.getAttribute("aria-label");
        return label != null ? label.toLowerCase() : "";
    }

    public SearchResultsPage filterByPrice(double low, double high) {
        low_price.sendKeys(String.valueOf(low));
        high_price.sendKeys(String.valueOf(high));
        submitForm.submit();
        return new SearchResultsPage(webDriver);
    }

    public SearchResultsPage sortingByLowToHighPrice() {
        dropDownPrompt.click();
        sort_select.click();
        return new SearchResultsPage(webDriver);
    }
}
