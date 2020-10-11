package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.openPage();
        loginPage.enterLogin(USERNAME, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99");
        cartPage.openCheckoutPage();
        checkoutPage.enteredFirstNameLastNamePostCodeAndGoToNextPage("123", "123", "123");
    }

    @Test
    public void buttonAddToCartShouldBeWork() {
        productsPage
                .openPage()
                .isPageOpened()
                .buttonsAddToCartShouldBeEnabled();
    }

    @Test
    public void buttonsOnThePageWithDescriptionProductsShouldBeWork() {
        productsPage
                .openPage()
                .isPageOpened()
                .findBlockWithDescriptionProductAndTestButton("Sauce Labs Backpack");
    }

    @Test
    public void imageProductsAndNameProductsShouldBeClickable() {
        productsPage.
                openPage()
                .isPageOpened()
                .findImageProductsAndTest()
                .findNameProductsAndTest();
    }

    @Test
    public void buttonAddToCartShouldSwitchToRemoveAndBack() {
        productsPage.
                openPage()
                .isPageOpened()
                .buttonsAddToCartShouldSwitch(3);
        String removeButton = productsPage.buttonsAddToCartShouldSwitchOnRemoveTest(3);
        assertEquals(removeButton, "REMOVE");
        productsPage.buttonsAddToCartShouldSwitch(3);
        String addToCartButton = productsPage.buttonsAddToCartShouldSwitchOnRemoveTest(3);
        assertEquals(addToCartButton, "ADD TO CART");
    }
}
