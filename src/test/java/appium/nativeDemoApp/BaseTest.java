package appium.nativeDemoApp;
import appium.nativeDemoApp.Screen.ScreenProvider;
import appium.nativeDemoApp.Screen.UIComponentProvider;
import appium.nativeDemoApp.util.TestListener;
import appium.nativeDemoApp.util.driver.MobileDriverFactory;
import appium.nativeDemoApp.util.driver.MobileDriverService;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

import static appium.nativeDemoApp.config.CommonConfig.EXECUTION_ENV_NAME;
import static appium.nativeDemoApp.config.CommonConfig.MOBILE_PLATFORM_NAME;
import static appium.nativeDemoApp.util.driver.MobileDriverHolder.getDriver;
import static appium.nativeDemoApp.util.driver.MobileDriverHolder.setDriver;

// Using Listeners annotation to modify TestNG behavior as per execution status.
@Listeners(TestListener.class)
public class BaseTest {
    private final MobileDriverService driverService = new MobileDriverFactory().getDriverService();
    private AppiumDriverLocalService appiumService;
    private final Logger logger = LogManager.getLogger();

    @BeforeSuite
    public void oneTimeSetup() {
        // Log test execution environment & platform in the beginning
        logger.debug("Test execution platform: {}", MOBILE_PLATFORM_NAME);
        logger.debug("Test execution environment: {}", EXECUTION_ENV_NAME);
    }

    // Start appium service and get the driver before each method
    @BeforeMethod
    public void openApp() {
        appiumService = driverService.startAppiumService();
        driverService.spinUpDriver(appiumService);
        setDriver(driverService.getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public ScreenProvider screen() {
        return new ScreenProvider(getDriver());
    }

    public UIComponentProvider uiComponent() {
        return new UIComponentProvider(getDriver());
    }

    // Cleanup after executing the method
    @AfterMethod
    public void closeApp() {
        driverService.closeDriver();
        driverService.stopAppiumService(appiumService);
    }
}
