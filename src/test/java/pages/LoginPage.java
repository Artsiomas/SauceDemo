package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

public class LoginPage extends AbstractBasePage {
    public static final String URL_END = "/index.html";
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERRORS_AUTHORIZATION = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get(URL + URL_END);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + LOGIN_BUTTON);
        }
        return this;
    }

    public void loginButtonClick() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void authorizationWithAddedOnlyUserName(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    public void authorizationWithAddedOnlyPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public String findErrorMessage() {
        return driver.findElement(ERRORS_AUTHORIZATION).getText();
    }

    public void errorAuthorizationIsOnThePage() {
        assertEquals(driver.findElement(ERRORS_AUTHORIZATION).getText(), "Epic sadface: Username is required", "Текст ошибки ДОЛЖЕН ПОЯВЛЯТЬСЯ и СООТВЕТСТВОВАТЬ заданному");
    }

    public void enterLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}