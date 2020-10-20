package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

public class CartPage extends AbstractBasePage {
    public static final String URL_CART_PAGE = URL + "/cart.html";
    public static final By BUTTON_CHECKOUT = By.cssSelector(".checkout_button");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[contains(text(),'Continue')]");
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openPage() {
        driver.get(URL_CART_PAGE);
        return this;
    }

    @Override
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_CHECKOUT));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + BUTTON_CHECKOUT);
        }
        return this;
    }

    public void buttonForContinueShoppingClick() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON);
    }

    public void productDetailsShouldBeLike(String productName, String quantity, String price) {
        String actualPrice = driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
        String actualQuantity = driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
        assertEquals(actualPrice, price, "Price is not correct");
        assertEquals(actualQuantity, quantity, "Price is not correct");
    }

    public void openCheckoutPage() {
        driver.findElement(BUTTON_CHECKOUT).click();
    }

}

