package pages;

import org.openqa.selenium.WebDriver;


import operations.Operations;

public class BasePage {
	protected WebDriver driver;
	protected Operations ops;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.ops = new Operations(driver);
		
	}


}
