package com.twoitesting.pomPages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPOM {

    private WebDriver driver;

    public CartPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#coupon_code")
    private WebElement discountCodeField;

    @FindBy(name = "apply_coupon")
    private WebElement applyDiscountButton;

    @FindBy(css = ".woocommerce-Price-amount")
    private WebElement subTotal;

    @FindBy(linkText = "Checkout")
    private WebElement checkoutLink;

    @FindBy(tagName = "body")
    private WebElement body;

    public void addDiscountCode(String discountCode) throws InterruptedException {
        discountCodeField.clear();
        discountCodeField.sendKeys(discountCode + Keys.ENTER);
        Thread.sleep(3000);
        applyDiscountButton.click();
    }

    public void confirmDiscountCodeApplied () {
        assertTrue(body.getText().contains("Coupon code applied successfully."), "Discount code not applied");
    }

    public void goToCheckout() {
        checkoutLink.click();
    }
}

