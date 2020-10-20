package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    String ADDED_YOUR_FIRST_NAME = "#first-name";
    String ADDED_YOUR_lAST_NAME = "#last-name";
    String ADDED_YOUR_POST_CODE_NAME = "#postal-code";
    String BUTTON_FOR_CONTINUE_BUY = "[value=CONTINUE]";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enteredFirstNameLastNamePostCodeAndGoToNextPage(String firstName, String lastName, String postCode) {
        driver.findElement(By.cssSelector(ADDED_YOUR_FIRST_NAME)).sendKeys(firstName);
        driver.findElement(By.cssSelector(ADDED_YOUR_lAST_NAME)).sendKeys(lastName);
        driver.findElement(By.cssSelector(ADDED_YOUR_POST_CODE_NAME)).sendKeys(postCode);
        driver.findElement(By.cssSelector(BUTTON_FOR_CONTINUE_BUY)).click();
    }
}
