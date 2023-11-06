package com.twoitesting.pomPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPOM {

    private WebDriver driver;

    public ShopPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#menu-item-43")
    private WebElement shopLink;

    @FindBy(css = "#woocommerce-product-search-field-0")
    private WebElement searchProductsField;

    @FindBy(css = ".single_add_to_cart_button")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-contents")
    private WebElement viewCartLink;


    public void addItemToCart(String item) {
        shopLink.click();
        searchProductsField.sendKeys(item + Keys.ENTER);
        addToCartButton.click();
    }

    public void viewCart() {
        viewCartLink.click();
    }
}
