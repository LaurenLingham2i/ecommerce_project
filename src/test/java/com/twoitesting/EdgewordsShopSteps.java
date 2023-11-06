package com.twoitesting;

import com.twoitesting.pomPages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EdgewordsShopSteps {

    private WebDriver driver;
    private String baseUrl;
    private String username;
    private String password;

    public EdgewordsShopSteps() {
        this.driver = new ChromeDriver();
        this.baseUrl = "https://www.edgewordstraining.co.uk/demo-site/my-account/";
        username = "lauren.lingham@2itesting.com";
        password = "Edgeword2023";
    }

    @Before
    public void setUp() {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector(".woocommerce-store-notice__dismiss-link")).click();

        LoginPOM loginPage = new LoginPOM(driver);
        loginPage.login(username, password);
    }

    @Given("I have added an item to my cart")
    public void i_have_added_an_item_to_my_cart() {
        ShopPOM shopPage = new ShopPOM(driver);
        shopPage.addItemToCart("cap");
        shopPage.viewCart();
    }

    @When("I apply a discount code")
    public void i_apply_a_discount_code() throws InterruptedException {
        CartPOM cartPOM = new CartPOM(driver);
        cartPOM.addDiscountCode("edgewords");
    }

    @Then("The discount should have been applied")
    public void the_discount_should_have_been_applied() {
        CartPOM cartPOM = new CartPOM(driver);
        cartPOM.confirmDiscountCodeApplied();
    }

    @When("I complete the purchase")
    public void i_complete_the_purchase() throws InterruptedException {
        CartPOM cartPOM = new CartPOM(driver);
        cartPOM.goToCheckout();

        CheckoutPOM checkoutPOM = new CheckoutPOM(driver);
        checkoutPOM.placeOrder();
    }

    @Then("I can view the order")
    public void i_can_view_the_order() throws InterruptedException {
        Thread.sleep(3000);
        String orderNumber = driver.findElement(By.className("woocommerce-order-overview__order"))
                .getText().replaceAll("[^0-9]", "");
        System.out.println("Order number: " + orderNumber);
        driver.findElement(By.id("menu-item-46")).click();
        driver.findElement(By.linkText("Orders")).click();
        String orderTableText = driver.findElement(By.tagName("table")).getText();
        System.out.println(orderTableText);
        assertTrue(orderTableText.contains(orderNumber), "Order not found");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}