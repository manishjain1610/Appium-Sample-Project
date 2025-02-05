package appium.nativeDemoApp.util.driver;
import appium.nativeDemoApp.config.DriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.io.File;
import static appium.nativeDemoApp.config.DriverConfig.ANDROID_APP_PACKAGE;

// Class to implement MobileDriverService interface
public class AndroidDriverServiceImpl implements MobileDriverService {
    private AndroidDriver androidDriver;

    // Annotation to indicate that the method is overriding/implementing method from interface
    @Override
    public void spinUpDriver(AppiumDriverLocalService appiumService) {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(DriverConfig.ANDROID_DEVICE_NAME)
                .setApp(new File(DriverConfig.ANDROID_APP_FILE_PATH).getAbsolutePath())
                .setAppActivity(DriverConfig.ANDROID_APP_ACTIVITY)
                .setNoReset(Boolean.parseBoolean(DriverConfig.ANDROID_NO_RESET))
                .setFullReset(Boolean.parseBoolean(DriverConfig.ANDROID_FULL_RESET))
                .autoGrantPermissions();

        // Instantiate new android driver and set implicit wait timeout
        androidDriver = new AndroidDriver(appiumService.getUrl(), options);
        androidDriver.manage().timeouts().implicitlyWait(DriverConfig.APPIUM_DRIVER_TIMEOUT);
    }

    @Override
    public void closeDriver() {
        androidDriver.terminateApp(ANDROID_APP_PACKAGE);
    }

    @Override
    public AppiumDriver getDriver() {
        return androidDriver;
    }
}
