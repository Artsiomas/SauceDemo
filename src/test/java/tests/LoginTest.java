package tests;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldNotPassAuthorizationWhenEnteredNothing() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginButtonClick();
        loginPage.errorAuthorizationIsOnThePage();
    }

    @Test
    public void userShouldNotPassAuthorizationWhenEnteredOnlyUserName() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.authorizationWithAddedOnlyUserName(USERNAME);
        loginPage.loginButtonClick();
        loginPage.errorAuthorizationIsOnThePage();
    }

    @Test
    public void userShouldNotPassAuthorizationWhenEnteredOnlyPassword() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.authorizationWithAddedOnlyPassword(PASSWORD);
        loginPage.loginButtonClick();
        loginPage.errorAuthorizationIsOnThePage();
    }

    @Test
    public void userShouldNotPassAuthorizationWithoutCorrectUserNameAndPassword() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.authorizationWithAddedOnlyUserName("USERNAME");
        loginPage.authorizationWithAddedOnlyPassword("PASSWORD");
        loginPage.loginButtonClick();
        loginPage.errorAuthorizationIsOnThePage();
    }

    @Test
    public void userShouldEnterCorrectPasswordAndUserNameForAuthorization() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.authorizationWithAddedOnlyUserName(USERNAME);
        loginPage.authorizationWithAddedOnlyPassword(PASSWORD);
        loginPage.loginButtonClick();
        productsPage.isPageOpened();
    }
}