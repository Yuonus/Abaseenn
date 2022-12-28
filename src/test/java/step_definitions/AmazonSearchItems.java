package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonSearchPages;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonSearchItems {
	
	AmazonSearchPages amz = new AmazonSearchPages();
	
	@Given("I am on the amazon home page")
	public void i_am_on_the_amazon_home_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	   System.out.println("I am on amazon homepage");
	}
	
	@Then("I should be directed to Amazon homepage")
	public void i_should_be_directed_to_amazon_homepage() {
		Assert.assertTrue(amz.flag.isDisplayed());
		System.out.println("The USA flag is displayed");
	}
	
	@When("I search {string}")
	public void i_search(String items) {
	  amz.search.sendKeys(items);
	  System.out.println("The search should run 5 times");
	}
	
	@When("I click the search button")
	public void i_click_the_search_button() {
	  amz.searchBtn.click();
	  Assert.fail();
	  System.out.println("I clicked on the search button");
	}
	
	@Then("Searched item {string} should be displayed in the search bar")
	public void searched_item_should_be_displayed_in_the_search_bar(String item) {
		String wholeText = amz.searchTxt.getText();
		String trimmedTxt = wholeText.substring(1, wholeText.length()-1);
		Assert.assertEquals(wholeText, trimmedTxt);
		System.out.println("Test passed");
		
		
	}

}
