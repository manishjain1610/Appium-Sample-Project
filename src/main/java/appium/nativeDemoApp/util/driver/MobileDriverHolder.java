package appium.nativeDemoApp.util.driver;

import io.appium.java_client.AppiumDriver;

// Utility class to manage the lifecycle of an AppiumDriver instance.
public class MobileDriverHolder {

    // ThreadLocal ensures each thread accessing it gets its own, isolated instance of the driver
    // to avoid conflicts in multithreaded testing environment
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    // Returns the AppiumDriver instance for the current thread
    public static AppiumDriver getDriver() {
        return driver.get();
    }

    // Sets the AppiumDriver instance for the current thread
    public static void setDriver(AppiumDriver driver) {
        MobileDriverHolder.driver.set(driver);
    }

    // Method to remove the driver when a test is complete to prevent memory leaks
    public static void removeDriver() {
        driver.remove();
    }

}