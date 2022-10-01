package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;


public class LandingPageStepDefinition {


	
public WebDriver driver;
public String landingPageproductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
LandingPage landingPage;

public LandingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup = testContextSetup;
	this.landingPage = testContextSetup.pageObjectManager.getLandingPage();	
}
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		landingPage.searchItem(shortname);
		Thread.sleep(3000);
		testContextSetup.landingPageproductName = landingPage.getproductName().split("-")[0].trim();
		System.out.println(landingPageproductName + "is extracted from home page.");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity){		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	

}
