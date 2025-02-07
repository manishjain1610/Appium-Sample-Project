package appium.nativeDemoApp;
import appium.nativeDemoApp.annotation.Feature;
import org.testng.annotations.Test;
import static appium.nativeDemoApp.config.AlertConfig.SIGNUP_ALERT;
import static appium.nativeDemoApp.Constant.Feature.SIGN_UP;
import static appium.nativeDemoApp.config.LoginConfig.PASSWORD;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static org.testng.Assert.assertEquals;

public class SignupTest extends BaseTest {
    @Feature(SIGN_UP)
    @Test(description = "Verify that a user can signup to the application")
    public void testSignup() {
        screen().getNavigationBarScreen()
                .tapOnLoginIcon();
        screen().getLoginScreen()
                .tapOnSignUpContainer()
                .signUp(emails().domain("startup.io").val(), PASSWORD, PASSWORD);
        assertEquals(
                uiComponent().getAlertScreen().getAlertTitle(),
                SIGNUP_ALERT.getAlertTitle()
        );
        assertEquals(
                uiComponent().getAlertScreen().getAlertMessage(),
                SIGNUP_ALERT.getAlertMessage()
        );
    }
}
