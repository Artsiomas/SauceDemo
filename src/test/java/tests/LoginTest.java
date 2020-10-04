package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    public static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

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
}
