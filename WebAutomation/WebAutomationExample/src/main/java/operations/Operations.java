package operations;


import org.openqa.selenium.*;


import org.openqa.selenium.interactions.Actions;
import web.WebObject;

import java.util.List;


public class Operations {
	private WebDriver driver;
	
	
	public Operations(WebDriver driver) {
		
		this.driver = driver;
		
	}

	private WebElement findWebElementOnPage(WebObject webObject){
	WebElement element = driver.findElement(By.xpath(webObject.xPath));
	System.out.println("Web Object " + webObject.description + " was found");
	return element;
}

//check if element visible on page
    public boolean isElementDisplayedOnPage(WebObject webObject){
	boolean present = false;
	try {
		WebElement webElement = findWebElementOnPage(webObject);
		if (webElement.isDisplayed() == true) {
			present = true;
		}
	}catch(Exception e){}
	return present;

    }

//check if element present in page
	public boolean isElementPresentOnPage(WebObject webObject){
		boolean present = false;
		try {
			WebElement webElement = findWebElementOnPage(webObject);
			if (webElement != null) {
				present = true;
			}
		}catch(Exception e){}
		return present;

	}


// find list of web elements
	public List<WebElement> findListWebElementOnPage(WebObject webObject){
		List<WebElement> elements = driver.findElements(By.xpath(webObject.xPath));
		System.out.println("Web Object " + webObject.description + " was found");
		return elements;
	}


	public WebElement getWebElement(WebObject webObject){

		WebElement webElement = findWebElementOnPage(webObject);

		return webElement;
	}
//click on web element
	public Operations clickOnWebElement_Usual(WebObject webObject){

		WebElement webElement = findWebElementOnPage(webObject);
		webElement.click();
		System.out.println("Clicking on " + webObject.description);
		return this;
	}
// page back
	public Operations navigatePageBack(){
	driver.navigate().back();
	return this;
	}
//refresh page
	public Operations navigatePageRefresh(){
		driver.navigate().refresh();
		return this;
	}

//click on web element using class Actions
	public Operations clickOnWebElement(WebObject webObject){

		WebElement webElement = findWebElementOnPage(webObject);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		System.out.println("Clicking on " + webObject.description);
		return this;
	}

//click on web element using class Actions
	public Operations clickOnWebElementElement(WebElement webElement){
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();

		return this;
	}

//emulate mouse moving over element and after that clicking
	public Operations moveOverWebElementAndClick(WebElement element){

		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		System.out.println("Hoover over " + element.toString());
		element.click();
		return this;
	}
//emulate mouse moving over element
	public Operations moveOverWebElement(WebElement element){

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		System.out.println("Hoover over " + element.toString());

		return this;
	}
//clear input field
	public Operations clearWebElement(WebObject webObject){
		WebElement webElement = findWebElementOnPage(webObject);
		webElement.clear();
		System.out.println("Clear" + webObject.description);
		return this;
}
//type to web element
	public Operations typeToWebElement(WebObject webObject, String data){
		WebElement webElement = findWebElementOnPage(webObject);
		webElement.sendKeys(Keys.CONTROL + "a");
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys(data);
		System.out.println("Type to" + webObject.description);
	
		return this;
}

	public void typeData(WebObject webObject, String data){
		WebElement webElement = findWebElementOnPage(webObject);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(data);
		System.out.println("Write to" + webObject.description);
}
//type to web element and press Enter
	public void typeDataPressEnter(WebObject webObject, String data){
		WebElement webElement = findWebElementOnPage(webObject);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(data);
		webElement.sendKeys(Keys.ENTER);
		System.out.println("Write to" + webObject.description);
	}
//get text from web element
	public String getTextfromElement(WebObject webObject){
		try {
			WebElement webElement = findWebElementOnPage(webObject);
			String text = webElement.getText();
			return text;
		}catch(org.openqa.selenium.StaleElementReferenceException ex){
			WebElement webElement = findWebElementOnPage(webObject);
			String text = webElement.getText();
			return text;
	}

}

	public void fillWebElementsListWithDataIncreaseOn10(WebObject webObject,WebObject webObject1){
	List<WebElement> elements = findListWebElementOnPage(webObject);
	List<WebElement> elements1 = findListWebElementOnPage(webObject1);

	for(int i=0;i < elements.size(); i++ ){
		elements.get(i).click();
		elements.get(i).clear();
		elements.get(i).sendKeys(Integer.toString(i*10));
		elements1.get(i).click();
		elements1.get(i).clear();
		elements1.get(i).sendKeys(Integer.toString((i+1)*10));
	}

}
//get web element attribute value
	public String getWebElementAttributeValue(WebObject webObject, String string){
		String attributeValue = null;
		WebElement webElement = findWebElementOnPage(webObject);
		attributeValue = webElement.getAttribute(string);

		return attributeValue;
}













}
