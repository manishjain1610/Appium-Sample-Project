package appium.nativeDemoApp.config;
import static appium.nativeDemoApp.util.PropertyReader.getEnvironmentConfig;
public class LoginConfig {
    public static final String EMAIL_ADDRESS = getEnvironmentConfig("email_address");
    public static final String PASSWORD = getEnvironmentConfig("password");
}
