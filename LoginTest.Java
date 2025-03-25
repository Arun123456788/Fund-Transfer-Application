package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickLogin();

        // Add assertion based on expected behavior (e.g., redirect to dashboard)
        Assert.assertEquals(driver.getCurrentUrl(), "https://example.com/banking-dashboard");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid username or password.");
    }
}
