package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamingChairsPage extends BasePage {
    @FindBy(xpath = "//summary[@class=\"Header-link\"]/img")
    private WebElement profileDropDownButton;

    @FindBy(xpath = "(//*[@id=\"brandsRefinements\"]//li)[2]")
    private static WebElement brandLi;

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

    private final WebElement brandInput = brandLi.findElement(By.tagName("input"));

    public GamingChairsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void filterByBrand() {
        brandInput.sendKeys(Keys.SPACE);
    }

    public static String findBrand() {
        String label = brandLi.getAttribute("aria-label");
        return label != null ? label.toLowerCase() : "";
    }

    public void filterByPrice(double low, double high) {
        low_price.sendKeys(String.valueOf(low));
        high_price.sendKeys(String.valueOf(high));
        submitForm.submit();
    }

    public void sortingByLowToHighPrice() {
        dropDownPrompt.click();
        sort_select.click();
    }
}
