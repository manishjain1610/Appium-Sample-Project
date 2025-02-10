Sample Appium Project to show Native Android Demo App automation

This project shows sample code for automating Android using codebase with TestNG and the Appium library and generates Extent reports. A big thanks to Osanda Deshan for his help with framework structuring and best practices tips.

Prerequisites
    Java
    Maven
    NodeJS

How to install the dependencies. 

Setting up Appium environment requires a bit of elbow grease so feel free to seek help or ask me.

      1. Download and install JDK.
      2. Download and install Android Studio.
      3. Download and install	Android SDK.
      4. Download and install node.js
      5. Install Appium 2.0 (You may refer to the official Appium documentation) using "npm install -g appium" or "npm install -g appium@next" or "npm install -g appium@2.4.1" (Because of driver compatibility)
    	Good idea to also install "npm install @appium/doctor --location=global" as it disgnoses and fixes common node, ios or android issues.
       6. For client, use selenium java libraries.
       7. Download appium java client. 
       8. Download commons-lang3 and add to POM file. Please see the pom.xml file for all dependencies.
       9. Add JAVA_HOME environment variable.
       10. Add ANDROID_HOME environment variable. and add it to PATH variable along with %ANDROID_HOME%\platform-tools
       11. Add JAVA_HOME/bin directory to Path variable.
       12. Install appium drivers. For android -  appium driver install uiautomator2
       13. "appium driver list --installed" should list the driver uiautomator2
       14. Install the apk file to provide the app being tested. Sample -
    	  ./adb install C:\<Your directory>\android.wdio.native.app.v1.0.8.apk
       
        15. To find the package and activity to test. 
      	  a> Open device using avd manager. Launch the simulated device and "open the APP to be tested."
      	  b> Check the device is running using command - %ANDROID_HOME%\platform-tools\ adb devices or to launch emulator/simulated device from command like -
      		emulator -list-avds (to list all of your emulators) and emulator -avd name-of-your-emulator to launch your emulator.
      	  c> Get the package/activity using command - ./adb shell "dumpsys activity activities" > C:\<Any Directory>\out.log
      	  d> Opent the log file and search for mCurrentFocus
      	  The output will be like mCurrentFocus=Window{d788235 u0 com.google.android.calculator/com.android.calculator2.Calculator}
      	  Here com.google.android.calculator is package.
      	  and com.android.calculator2.Calculator is activity.
      	
          16. Download and install Appium Inspector to find locators from github page https://github.com/appium/appium-inspector/releases
          17. Install and launch Appium Inspector.
          18. Add json for device capabilities in Appium inspector like -
        	{
            "platformName": "Android",
            "deviceName": "<Your device name>",
            "app": "C:/<Your directory>/android.wdio.native.app.v1.0.8.apk",
            "automationName": "UiAutomator2"
            }
          19. Start session and find element locators. https://kobiton.com/blog/how-to-use-the-appium-inspector/
          20. Launch the test and start running steps.
          21. For andriod native demo app, download from https://github.com/webdriverio/native-demo-app/releases

After test execution, the Extent reports will be in - <Project home>\reports\html-reports directory
The logs will be available in <Project home>\logs directory.

How to run tests
  Using IntelliJ IDEA

    Go to Maven Profiles
    Select android Maven Profile as the platform
    Select qa as the environment (You may add your own environment files for dev, pre-prod or prod environments)
    Select the test classes on the src/test/java folder
    Right-click and click on Run

Using Command Line

  To run the smoke test suite in Android against the QA environment
  
      mvn clean test -Pandroid,qa,smoke-test

  To run the regression test suite in Android against the QA environment
   
      mvn clean test -Pandroid,qa,regression-test

  Note: By default, if no Maven profiles are selected, the tests will be executed on the android platform and in the qa environment.
