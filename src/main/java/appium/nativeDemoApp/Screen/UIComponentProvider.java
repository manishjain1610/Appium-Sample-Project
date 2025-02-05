package appium.nativeDemoApp.Screen;
import org.openqa.selenium.WebDriver;
import appium.nativeDemoApp.Screen.BaseScreen;

public class UIComponentProvider extends BaseScreen {
    public UIComponentProvider(WebDriver driver) {
        super(driver);
    }

    public AlertScreen getAlertScreen() {
        return new AlertScreen(driver);
    }
}
