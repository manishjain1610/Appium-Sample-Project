package appium.nativeDemoApp.Screen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy (accessibility="button-sign-up-container")
    private WebElement signupContainer;
    @AndroidFindBy (accessibility="input-email")
    private WebElement emailInput;
    @AndroidFindBy (accessibility="input-password")
    private WebElement passwordInput;
    @AndroidFindBy (accessibility="input-repeat-password")
    private WebElement repeatPassword;
    @AndroidFindBy (accessibility="button-LOGIN")
    private WebElement loginButton;
    @AndroidFindBy (accessibility="button-SIGN UP")
    private WebElement signupButton;

    public LoginScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String emailAddress, String password) {
        inputEmailAddress(emailAddress);
        inputPassword(password);
        tapOnLoginButton();
    }

    public LoginScreen tapOnSignUpContainer() {
    //    tap(AppiumBy.accessibilityId("button-sign-up-container"));
        int centerX = signupContainer.getLocation().getX() + (signupContainer.getSize().getWidth() / 2);
        int centerY = signupContainer.getLocation().getY() + (signupContainer.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(List.of(tap));
        return this;
    }

    public void signUp(String emailAddress, String password, String confirmPassword) {
        inputEmailAddress(emailAddress);
        inputPassword(password);
        inputConfirmPassword(confirmPassword);
        tapOnSignUpButton();
    }

    private void inputEmailAddress(String emailAddress) {
    //    inputText(AppiumBy.accessibilityId("input-email"), emailAddress);
        emailInput.clear();
        emailInput.sendKeys(emailAddress);
    }

    private void inputPassword(String password) {
    //    inputText(AppiumBy.accessibilityId("input-password"), password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    private void inputConfirmPassword(String confirmPassword) {
    //    inputText(AppiumBy.accessibilityId("input-repeat-password"), confirmPassword);
        repeatPassword.clear();
        repeatPassword.sendKeys(confirmPassword);
    }

    private void tapOnLoginButton() {
    //    tap(AppiumBy.accessibilityId("button-LOGIN"));
        int centerX = loginButton.getLocation().getX() + (loginButton.getSize().getWidth() / 2);
        int centerY = loginButton.getLocation().getY() + (loginButton.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(List.of(tap));
    }

    private void tapOnSignUpButton() {
    //    tap(AppiumBy.accessibilityId("button-SIGN UP"));
        int centerX = signupButton.getLocation().getX() + (signupButton.getSize().getWidth() / 2);
        int centerY = signupButton.getLocation().getY() + (signupButton.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(List.of(tap));
    }
}
