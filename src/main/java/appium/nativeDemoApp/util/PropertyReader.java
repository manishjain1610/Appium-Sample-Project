package appium.nativeDemoApp.util;
import appium.nativeDemoApp.config.CommonConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getAppiumConfig(String propertyName) {
        return getPropertyValue("appium.properties", propertyName);
    }

    public static String getDeviceConfig(String propertyName) {
        return getPropertyValue("device.properties", propertyName);
    }

    public static String getEnvironmentConfig(String propertyName) {
        return getPropertyValue(("env/" + CommonConfig.EXECUTION_ENV_NAME + ".properties"), propertyName);
    }

    public static String getReporterConfig(String propertyName) {
        return getPropertyValue(("test-reporter.properties"), propertyName);
    }

    private static String getPropertyValue(String filename, String propertyName) {
        String propertyValue;

        try (InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(filename)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return propertyValue;
    }
}
