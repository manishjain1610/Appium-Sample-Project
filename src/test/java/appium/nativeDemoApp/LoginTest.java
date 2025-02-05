package appium.nativeDemoApp;
import appium.nativeDemoApp.annotation.Feature;
import org.testng.annotations.Test;

import static appium.nativeDemoApp.config.AlertConfig.LOGIN_ALERT;
import static appium.nativeDemoApp.Constant.Feature.LOGIN;
import static appium.nativeDemoApp.config.LoginConfig.EMAIL_ADDRESS;
import static appium.nativeDemoApp.config.LoginConfig.PASSWORD;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Feature(LOGIN)
    @Test(description = "Verify that a user can login to the application with valid credentials")
    public void testValidLogin() {
        screen().getNavigationBarScreen()
                .tapOnLoginIcon();
        screen().getLoginScreen()
                .login(EMAIL_ADDRESS, PASSWORD);

        // Verify that login alert title is correct
        assertEquals(
                uiComponent().getAlertScreen().getAlertTitle(),
                LOGIN_ALERT.getAlertTitle()
        );

        // Verify that login alert message is correct
        assertEquals(
                uiComponent().getAlertScreen().getAlertMessage(),
                LOGIN_ALERT.getAlertMessage()
        );
    }
}
