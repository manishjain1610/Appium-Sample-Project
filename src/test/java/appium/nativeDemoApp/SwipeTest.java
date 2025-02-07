package appium.nativeDemoApp;
import appium.nativeDemoApp.annotation.Feature;
import static appium.nativeDemoApp.Constant.Feature.SWIPE;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {
    @Feature(SWIPE)
    @Test(description = "Verify that 'You found me!!!' log can be found at the bottom of the screen'")
    public void testYouFoundMeLogo() {
        screen().getNavigationBarScreen()
                .tapOnSwipeIcon();
        screen().getSwipeScreen()
                .scrollToFindMeLogo();
    }
}
