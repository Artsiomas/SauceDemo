package hw9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SauceDemoTestHW9 {

    WebDriver driver;
    public static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    public static final String BASE_PAGE_URL = "https://www.saucedemo.com/inventory.html";

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
    public void registrationWithoutAddedUserNameAndPassword() {
        driver.get(LOGIN_PAGE_URL);

        //сразу кликаем на кнопку регистрации, без ввода логина и пароля
        WebElement searchRegistrationErrors = driver.findElement(By.id("login-button"));
        searchRegistrationErrors.click();
        driver.findElement(By.cssSelector("[data-test=error]"));
        assertTrue(driver.findElement(By.cssSelector("[data-test=error]")).isDisplayed(), "Ошибка должна отображаться");


    }

    @Test
    public void loginPageRegistrationAddedOnlyPassword() {
        driver.get(LOGIN_PAGE_URL);
       //вводим пароль и кликаем на кнопку регистрации, без ввода логина
        WebElement enterYourPassword = driver.findElement(By.id("password"));
        enterYourPassword.sendKeys("secret_sauce");
        WebElement searchRegistrationErrors = driver.findElement(By.id("login-button"));
        searchRegistrationErrors.click();
        assertTrue(driver.findElement(By.cssSelector("[data-test=error]")).isDisplayed(), "Ошибка должна отображаться");
    }

    @Test
    public void loginPageRegistrationAddedOnlyUserName() {
        driver.get(LOGIN_PAGE_URL);
        //вводим логин и кликаем на кнопку регистрации, без ввода пароля
        WebElement enterYourUsername = driver.findElement(By.id("user-name"));
        enterYourUsername.sendKeys("standard_user");
        WebElement searchRegistrationErrors = driver.findElement(By.id("login-button"));
        searchRegistrationErrors.click();
        assertTrue(driver.findElement(By.cssSelector("[data-test=error]")).isDisplayed(), "Ошибка должна отображаться");
    }

    @Test
    public void loginPageRegistrationWithNotCorrectUserNameAndPassword() {
        driver.get(LOGIN_PAGE_URL);
        //вводим не корректные логин и пароль
        WebElement enterYourUsername = driver.findElement(By.id("user-name"));
        enterYourUsername.sendKeys("Artsiom_Zagvozdin");
        WebElement enterYourPassword = driver.findElement(By.id("password"));
        enterYourPassword.sendKeys("qwerty123");
        WebElement searchRegistrationErrors = driver.findElement(By.id("login-button"));
        searchRegistrationErrors.click();
        assertTrue(driver.findElement(By.cssSelector("[data-test=error]")).isDisplayed(), "Ошибка должна отображаться");
    }


    @Test
    public void basePageAddProductButtonShouldBeWork() {
        driver.get(BASE_PAGE_URL);
        //проверка правильности работы кнопки 'Добавить в корзину'
        WebElement AddProductButton = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item']//button"));
        AddProductButton.click();
        driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item']//button"));
        assertEquals(AddProductButton.getText(), "REMOVE");
    }

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
