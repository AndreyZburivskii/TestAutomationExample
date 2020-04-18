package tests;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;


public class FirstTest extends BaseTest{
	public static HomePage homePage;
	public static SearchResultPage searchResultPage;

	SoftAssert softAssert = new SoftAssert();

	public void getClassName(){
		System.out.println("-------------------------------------------");
		System.out.println("TEST CASE: "+this.getClass().getSimpleName());
		System.out.println("-------------------------------------------");
	}

	public void navigateToHomePage(){
	 openUrl();

	}
//Test Case: Verify search results
	@Test(priority=10)

	public void verifyUserPositive() {
		getClassName();
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("-----"+methodName+"-----");
		navigateToHomePage();
		homePage = new HomePage(driver);
		homePage.setCheckInDate("10/01/2020");
		homePage.setCheckOutDate("10/05/2020");
		homePage.typeDestinationPressEnter("Tel Aviv");
		searchResultPage = new SearchResultPage(driver);
		softAssert.assertTrue(searchResultPage.verifySearchResults(1),"No result was found");


	}


}
	
	


