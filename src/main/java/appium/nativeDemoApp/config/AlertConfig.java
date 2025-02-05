package appium.nativeDemoApp.config;

import lombok.Getter;
@Getter
public enum AlertConfig {
    LOGIN_ALERT("Success", "You are logged in!"),
    SIGNUP_ALERT("Signed Up!", "You successfully signed up!");

    private final String alertTitle, alertMessage;

    AlertConfig(String alertTitle, String alertMessage) {
        this.alertTitle = alertTitle;
        this.alertMessage = alertMessage;
    }
}
