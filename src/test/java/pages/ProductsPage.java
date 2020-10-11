package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class ProductsPage extends AbstractBasePage {
    public final static String URL_END = "/inventory.html";
    public final static By BLOCK_WITH_DESCRIPTION_PRODUCT = By.cssSelector(".inventory_item");
    public final static By BUTTON_ADD_TO_CART = By.cssSelector(".btn_inventory");
    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        driver.get(URL + URL_END);
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(BLOCK_WITH_DESCRIPTION_PRODUCT));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + BLOCK_WITH_DESCRIPTION_PRODUCT);
        }
        return this;
    }

    public ProductsPage buttonsAddToCartShouldBeEnabled() {
        List<WebElement> buttonsAddToCartFind = driver.findElements(BUTTON_ADD_TO_CART);
        for (int i = 0; i < 6; i++) {
            if (buttonsAddToCartFind.get(i).isEnabled()) {
                i++;
            }
        }
        return this;
    }

    public ProductsPage buttonsAddToCartShouldSwitch(int numberOfButton) {
        List<WebElement> buttonsAddToCartFind = driver.findElements(BUTTON_ADD_TO_CART);
        buttonsAddToCartFind.get(numberOfButton).click();
        return this;
    }

    public String buttonsAddToCartShouldSwitchOnRemoveTest(int numberOfButton) {
        List<WebElement> buttonsAddToCartFind = driver.findElements(BUTTON_ADD_TO_CART);
        return buttonsAddToCartFind.get(numberOfButton).getText();
    }


    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }

    public ProductsPage findBlockWithDescriptionProductAndTestButton(String productName) {
        driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", productName))).click();
        List<WebElement> findAllButtonOnThePageWithDescription = driver.findElements(By.tagName("button"));
        for (int i = 0; i < 4; i++) {
            if (findAllButtonOnThePageWithDescription.get(i).isEnabled()) {
                i++;
            }
        }
        return this;
    }

    public ProductsPage findImageProductsAndTest() {
        int i = 0;
        List<WebElement> findClickableImage = driver.findElements(By.id("item_" + i + "_img_link"));
        for (i = 0; i < 6; i++) {
            if (findClickableImage.get(i).isEnabled()) {
                i++;
            }
        }
        return this;
    }

    public ProductsPage findNameProductsAndTest() {
        int i = 0;
        List<WebElement> findClickableNameProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
        for (i = 0; i < 6; i++) {
            if (findClickableNameProducts.get(i).isEnabled()) {
                i++;
            }
        }
        return this;
    }

}
