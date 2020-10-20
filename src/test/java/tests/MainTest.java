package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {

    public static final String BASE_PAGE_URL = URL + "/inventory.html";

    @Test
    public void basePageButtonBackShouldBeWork() {

        driver.get(BASE_PAGE_URL);
        //проверка страницы с карточкой товара на наличие необходимых активных кнопок
        WebElement findProduct = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]"));
        findProduct.click();
        WebElement findButtonBack = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_details']//button"));
        assertTrue(findButtonBack.isDisplayed(), "Кнопка должна быть на странице");
        WebElement shoppingCartContainer = driver.findElement(By.id("shopping_cart_container"));
        assertTrue(shoppingCartContainer.isDisplayed(), "Кнопка 'Перейти в корзину' должна отображаться");
        WebElement findButtonMenu = driver.findElement(By.xpath("//*[@class='bm-burger-button']"));
        assertTrue(findButtonMenu.isDisplayed(), "Кнопка 'Меню' должна быть на странице");
        WebElement findButtonAddToCArt = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_details_desc_container']//button"));
        assertTrue(findButtonAddToCArt.isDisplayed(), "Кнопка 'добавить в корзину' должна быть на странице");
    }
}



