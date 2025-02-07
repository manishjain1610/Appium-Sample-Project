package appium.nativeDemoApp.Screen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;
import io.appium.java_client.android.AndroidDriver;
import static appium.nativeDemoApp.config.CommonConfig.MOBILE_PLATFORM_NAME;
import static appium.nativeDemoApp.config.DriverConfig.ANDROID;


public class BaseScreen {
    public final WebDriver driver;
    public final WebDriverWait wait;

    @AndroidFindBy (accessibility ="Predicted app: wdiodemoapp")
    WebElement nativeDemoAppLaunchButton;
    /*
    @AndroidFindBy (xpath = "//*[contains(@text, 'PLACEHOLDER')]")
    WebElement swipeText;
    */
    public BaseScreen(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement scrollToElement(String elementText) {
        WebElement element;

        int maxScrolls = 5; // Set a limit to prevent infinite loops
        int scrollCount = 0;
        if (MOBILE_PLATFORM_NAME.equalsIgnoreCase(ANDROID)) {
            while (scrollCount < maxScrolls) {
                try {
                    element = driver.findElement(AppiumBy.androidUIAutomator(
                            "new UiSelector().text(\"" + elementText + "\")"));
                    if (element.isDisplayed()) {
                        System.out.println("Element found: " + elementText);
                        return element;
                    }
                } catch (Exception e) {
                    // Element not found, continue scrolling
                }
                // Perform swipe up
                if (scrollCount == 0)
                    swipeUpW3C(0.5);
                else
                    swipeUpW3C(0.8);
                scrollCount++;
            }

            throw new RuntimeException("Element with text '" + elementText + "' not found after " + maxScrolls + " swipes.");
        }
        else {
            element = driver.findElement(AppiumBy.iOSNsPredicateString("label == '" + elementText + "'"));
        }
        return element;
    }

    public void tap(By by) {
        waitUntilElementVisible(by);
        driver.findElement(by).click();
    }

    public void scrollAndTap(String elementText) {
        scrollToElement(elementText).click();
    }

    public void inputText(By by, String text) {
        waitUntilElementVisible(by);
        driver.findElement(by).sendKeys(text);
    }

    public void scrollAndInputText(String elementText, String text) {
        scrollToElement(elementText).sendKeys(text);
    }

    private void swipeUpW3C(Double startYOffset) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * startYOffset);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

       // driver.perform(Arrays.asList(swipe));
        ((AppiumDriver) driver).perform(List.of(swipe));
    }
}
