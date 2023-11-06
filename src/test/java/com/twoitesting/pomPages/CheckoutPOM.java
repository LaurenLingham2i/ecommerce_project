package com.twoitesting.pomPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutPOM {

    private WebDriver driver;

    public CheckoutPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#billing_first_name")
    private WebElement firstNameField;

    @FindBy(css = "#billing_last_name")
    private WebElement lastNameField;

    @FindBy(css = "#billing_address_1")
    private WebElement streetAddressField;

    @FindBy(css = "#billing_city")
    private WebElement townCityField;

    @FindBy(css = "#billing_postcode")
    private WebElement postCodeField;

    @FindBy(css = "#billing_phone")
    private WebElement phoneField;

    @FindBy(css = "#place_order")
    private WebElement placeOrderButton;

    public void placeOrder() throws InterruptedException {
        firstNameField.clear();
        firstNameField.sendKeys("A");
        lastNameField.clear();
        lastNameField.sendKeys("B");
        streetAddressField.clear();
        streetAddressField.sendKeys("C");
        townCityField.clear();
        townCityField.sendKeys("D");
        postCodeField.clear();
        postCodeField.sendKeys("EH2 2LE");
        phoneField.clear();
        phoneField.sendKeys("0");
        Thread.sleep(3000);
        placeOrderButton.click();
    }
}

