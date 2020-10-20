package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Входящие данные для регистрации")
    public Object[][] inputForLogin() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {USERNAME, "", "Epic sadface: Password is required"},
                {"", PASSWORD, "Epic sadface: Username is required"},
                {"USERNAME", "PASSWORD", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test(dataProvider = "Входящие данные для регистрации", description = "попытка регистрации при вводе не корректных данных")
    public void userShouldNotPassAuthorizationWhenEnteredNothing(String userName, String password, String errorMessage) {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.authorizationWithAddedOnlyUserName(userName);
        loginPage.authorizationWithAddedOnlyPassword(password);
        loginPage.loginButtonClick();
        assertEquals(loginPage.errorMessage(), errorMessage);

    }

    @Test
    public void userShouldNotPassAuthorizationWhenEnteredOnlyUserName() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.authorizationWithAddedOnlyUserName(USERNAME);
        loginPage.loginButtonClick();
    }
}