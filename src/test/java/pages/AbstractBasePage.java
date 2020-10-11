package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class AbstractBasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String URL = "https://www.saucedemo.com";

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    abstract public AbstractBasePage openPage();
    abstract public AbstractBasePage isPageOpened();
}

