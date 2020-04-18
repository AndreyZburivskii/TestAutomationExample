package driver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	private static final String DRIVER_DIR = "webdrivers";
	private static final String CHROME_PROPERTY_NAME = "webdriver.chrome.driver";
	private static final String FIREFOX_PROPERTY_NAME = "webdriver.gecko.driver";
	private static final String CHROME_DRIVER_EXE = "chromedriver.exe";
	private static final String FIREFOX_DRIVER_EXE = "geckodriver.exe";
	private static final String PROJECT_DIR = System.getProperty("user.dir");


	public static WebDriver getWebDriver() throws Exception {
		boolean headlessFlag = false;
		String headless = System.getProperty("headless");
		String browser = System.getProperty("browser");
		if(headless.equalsIgnoreCase("true")){
			headlessFlag = true;
		}
		System.out.println("==================================================================================");
		System.out.println("Starting: " + browser.toUpperCase()+". Headless mode is -"+headless.toUpperCase());
		System.out.println("==================================================================================");
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")){
			prepareDriver(CHROME_PROPERTY_NAME, CHROME_DRIVER_EXE);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(headlessFlag);
			// Disables GPU hardware acceleration.  If software renderer is not in place,
			// then the GPU process won't launch.
			chromeOptions.addArguments("disable-gpu");
			// Type of the current test harness ("browser" or "ui").
			chromeOptions.addArguments("--test-type");
			// By default, an https page cannot run JavaScript, CSS or plugins from http
			// URLs. This provides an override to get the old insecure behavior.
			chromeOptions.addArguments("allow-running-insecure-content");
			// Don't enforce the same-origin policy. (Used by people testing their sites.)
			chromeOptions.addArguments("disable-web-security");
			chromeOptions.addArguments("window-size=1920,1080");
			chromeOptions.addArguments("--enable-geolocation");
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("--proxy-server='direct://'");
			chromeOptions.addArguments("--proxy-bypass-list=*");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--whitelisted-ips=*");
			chromeOptions.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chromeOptions);

		} else if (browser.equalsIgnoreCase("firefox")){
			prepareDriver(FIREFOX_PROPERTY_NAME, FIREFOX_DRIVER_EXE);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(headlessFlag);
			// Disables GPU hardware acceleration.  If software renderer is not in place,
			// then the GPU process won't launch.
			firefoxOptions.addArguments("disable-gpu");
			// Type of the current test harness ("browser" or "ui").
			firefoxOptions.addArguments("--test-type");
			// By default, an https page cannot run JavaScript, CSS or plugins from http
			// URLs. This provides an override to get the old insecure behavior.
			firefoxOptions.addArguments("allow-running-insecure-content");
			// Don't enforce the same-origin policy. (Used by people testing their sites.)
			firefoxOptions.addArguments("disable-web-security");
			firefoxOptions.addArguments("-width=1920");
			firefoxOptions.addArguments("-height=1080");
			firefoxOptions.addArguments("--enable-geolocation");
			firefoxOptions.addArguments("--disable-extensions");
			firefoxOptions.addArguments("--proxy-server='direct://'");
			firefoxOptions.addArguments("--proxy-bypass-list=*");
			firefoxOptions.addArguments("--start-maximized");
			firefoxOptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(firefoxOptions);

		}




		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		return driver;


	}



	private static void prepareDriver(String propertyName, String driverExe) throws IOException {
		System.setProperty(
				propertyName,
				PROJECT_DIR
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + DRIVER_DIR
						+ File.separator + driverExe);
	}


}
