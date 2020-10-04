package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99");
        cartPage.openCheckoutPage();
        checkoutPage.enteredFirstNameLastNamePostCodeAndGoToNextPage("123", "123", "123");
    }
}
