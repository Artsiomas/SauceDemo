package pages;

import org.openqa.selenium.WebDriver;

abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
