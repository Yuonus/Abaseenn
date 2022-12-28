package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoPages;
import utilities.Driver;
import utilities.PropertiesReader;

public class SauceDemoDDT {
	SauceDemoPages aml = new SauceDemoPages();
	
	@Given("the user is on sauce demo home page")
	public void the_user_is_on_sauce_demo_home_page() {
	  Driver.getDriver().get(PropertiesReader.getProperty("sauceURL"));
	}
	@When("the user enter invalid username {string} and password {string}")
	public void the_user_enter_invalid_username_and_password(String username, String password) {
	   aml.userName.sendKeys(username);
	   aml.password.sendKeys(password);
	   
	}
	@When("the user click on the login button")
	public void the_user_click_on_the_login_button() {
		aml.login.click();
	}
	@Then("the user should not be able to login")
	public void the_user_should_not_be_able_to_login() {
	    Assert.assertTrue(aml.homepage.isDisplayed());
	}
	
	@Then("error message {string} should appear under the password field")
	public void error_message_should_appear_under_the_password_field(String string) {
		String actualTxt = aml.errorTxt.getText().trim();
		String txt = string;
		Assert.assertEquals(string, actualTxt);
		
	}

}
