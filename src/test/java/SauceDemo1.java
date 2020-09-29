import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SauceDemo1 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void SauceDemo() {

        //страничка регистрации
        driver.findElement(By.className("login_logo"));
        driver.findElement(By.className("bot_column"));

        WebElement searchRegistrationErrors = driver.findElement(By.id("login-button"));
        searchRegistrationErrors.click();
        driver.findElement(By.cssSelector("[data-test=error]"));

        WebElement enterYourUsername = driver.findElement(By.id("user-name"));
        enterYourUsername.sendKeys("111");
        searchRegistrationErrors.click();
        driver.findElement(By.cssSelector("[data-test=error]"));
        WebElement toClearUsername = driver.findElement(By.id("user-name"));
        toClearUsername.sendKeys(Keys.CONTROL + "a");
        toClearUsername.sendKeys(Keys.DELETE);

        WebElement enterYourPassword = driver.findElement(By.id("password"));
        enterYourPassword.sendKeys("111");
        searchRegistrationErrors.click();
        driver.findElement(By.cssSelector("[data-test=error]"));
        WebElement toClearPassword = driver.findElement(By.id("password"));
        toClearPassword.sendKeys(Keys.CONTROL + "a");
        toClearPassword.sendKeys(Keys.DELETE);

        enterYourUsername.sendKeys("standard_user");
        enterYourPassword.sendKeys("secret_sauce");
        searchRegistrationErrors.click();

       //каталог с товаром
        driver.findElement(By.className("bm-burger-button"));
        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        driver.findElement(By.className("app_logo"));
        driver.findElement(By.className("product_label"));
        driver.findElement(By.className("peek"));
        driver.findElement(By.className("product_label"));
        List<WebElement> nameGoods = driver.findElements(By.cssSelector("div.inventory_item_name"));
        List<WebElement> imageGoods = driver.findElements(By.cssSelector(".inventory_item_img"));
        List<WebElement> addToCartButton = driver.findElements(By.cssSelector(".btn_primary.btn_inventory"));
        List<WebElement> descriptionGoods = driver.findElements(By.cssSelector(".inventory_item_desc"));
        List<WebElement> costGoods = driver.findElements(By.cssSelector(".inventory_item_price"));
        driver.findElement(By.className("social_twitter"));
        driver.findElement(By.className("social_facebook"));
        driver.findElement(By.className("social_linkedin"));


        //выбираем товар и переходи в корину
        addToCartButton.get(0).click();
        shoppingCart.click();

        // ищем выбранный товар и выводим в консоль
        nameGoods = driver.findElements(By.cssSelector("div.inventory_item_name"));
        costGoods = driver.findElements(By.cssSelector("div.inventory_item_price"));
        System.out.println("Название товара: " + nameGoods.get(0).getText() + ". Его стоимость: " + costGoods.get(0).getText() );



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

