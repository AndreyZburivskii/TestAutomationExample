package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driver.Driver;
import org.testng.annotations.Parameters;

import java.util.Date;

public class BaseTest {

	public static WebDriver driver;
	
	@BeforeClass
	@Parameters
	public static void setUp() throws Exception{
		driver = Driver.getWebDriver();

	}
	
	@AfterClass
	public static void cleanUp(){
		//analyzeLog(); //doesn't work in firefox
		driver.quit();
	}
	
	public void openUrl(){
		String url = System.getProperty("url");
		driver.get(url);
	}

	//writes logs from chrome console
	public static void analyzeLog() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			//do something useful with the data
		}
	}

}

