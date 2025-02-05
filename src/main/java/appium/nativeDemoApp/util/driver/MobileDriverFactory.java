package appium.nativeDemoApp.util.driver;
import java.security.InvalidParameterException;

import static appium.nativeDemoApp.config.CommonConfig.MOBILE_PLATFORM_NAME;
import static appium.nativeDemoApp.config.DriverConfig.ANDROID;
// import static appium.nativeDemoApp.config.DriverConfig.IOS;

// Utility class used to create instances of MobileDriverService based on the mobile platform
// This class is a factory that provides Android or iOS driver services based on the configured platform
public class MobileDriverFactory {

    // Returns the interface MobileDriverService
    public MobileDriverService getDriverService() {
        MobileDriverService driver;

        switch (MOBILE_PLATFORM_NAME) {
            case ANDROID:
                driver = new AndroidDriverServiceImpl();
                break;
           /*
            case IOS:
                driver = new IosDriverServiceImpl();
                break;
            */
            default:
                throw new InvalidParameterException("Please use platform as '" + ANDROID + "' or '" + "<IOS>" + "'");
        }
        // After selecting the correct implementation return the driver service instance
        return driver;
    }
}
