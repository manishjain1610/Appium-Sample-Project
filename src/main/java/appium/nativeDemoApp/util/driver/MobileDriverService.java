package appium.nativeDemoApp.util.driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import static appium.nativeDemoApp.config.DriverConfig.APPIUM_SERVER_IP;
import static appium.nativeDemoApp.config.DriverConfig.APPIUM_SERVER_PORT;

// Interface that defines methods related to Appium driver management
public interface MobileDriverService {
    // Start Appium server with given properties
    default AppiumDriverLocalService startAppiumService() {
        AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withIPAddress(APPIUM_SERVER_IP)
                        .usingPort(APPIUM_SERVER_PORT)
        );
        appiumService.start();
        return appiumService;
    }

    // Stop Appium Server
    default void stopAppiumService(AppiumDriverLocalService appiumService) {
        appiumService.stop();
    }

    // Create & Start a Driver. Implemented in AndroidDriverServiceImpl class, Used in BaseTest class
    void spinUpDriver(AppiumDriverLocalService appiumService);

    // Shut down the driver. Implemented in AndroidDriverServiceImpl class
    void closeDriver();

    // Implemented in AndroidDriverServiceImpl class
    AppiumDriver getDriver();
}
