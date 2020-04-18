package pages;

import org.openqa.selenium.WebDriver;
import web.WebObject;

public class SearchResultPage extends BasePage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

//initialize webobjects on Page
	WebObject hotelSearchResult = new WebObject("hotel Search Result", "//div[@class='uitk-flex two-column-body']//li");

//verify if results greater than 1
	public boolean verifySearchResults(int minExpectedResults) {
		boolean result = false;
		int elemetsFound = ops.findListWebElementOnPage(hotelSearchResult).size();
		if(elemetsFound >= minExpectedResults){
			result = true;
		}
		return result;
		}


	
}
