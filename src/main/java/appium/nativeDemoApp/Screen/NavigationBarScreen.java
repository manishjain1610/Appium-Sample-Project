package appium.nativeDemoApp.Screen;
// import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class NavigationBarScreen extends BaseScreen {
    @AndroidFindBy (accessibility="Login")
    private WebElement loginIcon;
    @AndroidFindBy (accessibility="Swipe")
    private WebElement swipeIcon;

    public NavigationBarScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tapOnLoginIcon() {
//        tap(AppiumBy.accessibilityId("Login"));

        int centerX = loginIcon.getLocation().getX() + (loginIcon.getSize().getWidth() / 2);
        int centerY = loginIcon.getLocation().getY() + (loginIcon.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(List.of(tap));
      //  ((AppiumDriver) driver).perform(Collections.singletonList(tap));


    }

    public void tapOnSwipeIcon() {
    //    tap(AppiumBy.accessibilityId("Swipe"));
        int centerX = swipeIcon.getLocation().getX() + (swipeIcon.getSize().getWidth() / 2);
        int centerY = swipeIcon.getLocation().getY() + (swipeIcon.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(List.of(tap));
    }
}
