package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
public WebDriver driver;
public String landingPageproductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;

//Single repository principle
//Loosely coupled
//Factory design pattern

public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup = testContextSetup;
}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortname) throws InterruptedException {		
		
		switchToOffersPage();	
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();		
		offersPage.searchItem(shortname);
		Thread.sleep(3000);
		offerPageProductName = offersPage.getproductName();
	}
	
	public void switchToOffersPage() {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();		
		landingPage.selectTopDealsPage();		
		testContextSetup.genericUtils.SwitchWindowToChild();
		//explicit wait, parse string
	}
	
    @And("^validate productname in offers page matches with landing page$")
    public void validate_productname_in_offers_page_matches_with_landing_page() throws Throwable {
    	Assert.assertEquals(offerPageProductName, testContextSetup.landingPageproductName);
    }
}
