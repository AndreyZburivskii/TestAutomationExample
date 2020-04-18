package pages;

import org.openqa.selenium.WebDriver;

import web.WebObject;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	//initialize webobjects on Page
	WebObject hotelSearchField = new WebObject("hotel Search Field", "//input[@id='hotel-destination-hp-hotel']");
	WebObject checkInDateField = new WebObject("check In Date Field", "//input[@id='hotel-checkin-hp-hotel']");
	WebObject checkOutDateField = new WebObject("checkOutDateField", "//input[@id='hotel-checkout-hp-hotel']");
	WebObject searchButton = new WebObject("search Button", "//form[@id='gcw-hotel-form-hp-hotel']//button[contains(@class,'gcw-submit')]");
	



//fill up search field and press enter
	public HomePage typeDestinationPressEnter(String data) {
		
		ops.typeDataPressEnter(hotelSearchField, data);
		return this;
		}
//set check in date
	public HomePage setCheckInDate(String data) {
		
		ops.typeData(checkInDateField, data);
		return this;
		}
//set check out date
	public HomePage setCheckOutDate(String data) {

		ops.typeData(checkOutDateField, data);
		return this;
	}
//click on Search button
	public HomePage clickOnSearchButton() {

		ops.clickOnWebElement(searchButton);
		return this;
}

	
}
