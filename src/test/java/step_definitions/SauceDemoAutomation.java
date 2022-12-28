package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoPages;
import utilities.Driver;
import utilities.PropertiesReader;

public class SauceDemoAutomation {
	
	SauceDemoPages sauce = new SauceDemoPages();
	
//	@Given("I am on the sauce demo home page")
//	public void I_am_on_the_sauce_demo_home_page() {
//		Driver.getDriver().get(PropertiesReader.getProperty("sauceURL"));
//		boolean onHomePage = sauce.homepage.isDisplayed();
//		Assert.assertTrue(onHomePage);
//		System.out.println("The potential user is on sauce demo homepage");
//	}
	
	@When("The user enter a user name {string}")
	public void the_user_enter_a_user_name(String userName) {
	    sauce.userName.sendKeys(userName);
	}
	
	@When("The user enter a password {string}")
	public void the_user_enter_a_password(String passCode) {
	   sauce.password.sendKeys(passCode);
	}
	
	@When("The user click on login button")
	public void the_user_click_on_login_button() {
		sauce.login.click();
	}
	
	@Then("The user should be able to login with valid credentials")
	public void the_user_should_be_able_to_login_with_valid_credentials() {
	   Assert.assertTrue(sauce.sauceLoginPage.isDisplayed());
	   System.out.println("The user is directed to sauce demo login page");
	}
	
	@Then("The user should see a total of {int} items there")
	public void the_user_should_see_a_total_of_items_there(Integer number) {
		int itemsNumber = sauce.items.size();
		Assert.assertTrue(number == itemsNumber);
		System.out.println("The user could see a total of 6 items");
	}
	
	// Sauce Demo Invalid scenario test begin here
	
	@Given("I am on the sauce demo home page")
	public void i_am_on_the_sauce_demo_home_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("sauceURL"));
		Assert.assertTrue(sauce.homepage.isDisplayed());
		System.out.println("I was directed to homepage after entering the URL");
	}
	
	@When("I login with a user name {string} and a password {string}")
	public void i_login_with_a_user_name_and_a_password(String userName, String password) {
	   sauce.userName.sendKeys(userName);
	   sauce.password.sendKeys(password);
	}
	
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		sauce.login.click();
	}
	
	@Then("I should not be able to login with invalid password")
	public void i_should_not_be_able_to_login_with_invalid_password() {
		boolean robot = sauce.homepage.isDisplayed();
		Assert.assertTrue(robot);
		System.out.println("I was not allowed to login with invalid password");
	}
	
	@Then("the error message {string} should appear under the password field")
	public void the_error_message_should_appear_under_the_password_field(String error) {
	   String expected =  sauce.errorTxt.getText().trim();
	   Assert.assertEquals(expected, error);
	   System.out.println("The error message was drilled out.");
	   System.out.println(expected);
	}
}
