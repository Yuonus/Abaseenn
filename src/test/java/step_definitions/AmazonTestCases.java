package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPages;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonTestCases {
	
	AmazonPages amz = new AmazonPages();
	
	@Given("I am on amazon home page")
	public void i_am_on_amazon_home_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	}
	
	@Then("The sign in button displays")
	public void the_sign_in_button_displays() {
		boolean sign = amz.signInBtn.isDisplayed();
		Assert.assertTrue(sign);
		System.out.println("The sign in button displays on amazon home page");
	}
	
	@When("I click on the sign in button")
	public void i_click_on_the_sign_in_button() {
		amz.signInBtn.click();
	}
	
	@Then("I should be directed to the log in page")
	public void i_should_be_directed_to_the_log_in_page() {
		boolean bool = amz.createAcc.isDisplayed();
		Assert.assertTrue(bool);
		System.out.println("I am directed to the log in page");
	}
	
	// Amazon invalid log in starts here
	@Given("I am on amazon log in page")
	public void i_am_on_amazon_log_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
		amz.signInBtn.click();
		Assert.assertTrue(amz.createAcc.isDisplayed());
	}
	
	@When("I enter an invalid email {string}")
	public void i_enter_an_invalid_email(String email) {
		amz.emailPhone.sendKeys(email);
	}
	
	@When("I click the continue button")
	public void i_click_the_continue_button() {
		amz.contBtn.click();
	}
	
	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String errorMesage) {
		boolean ble = amz.errorMsg.isDisplayed();
		String actualTxt = amz.errorMsg.getText().trim();
		Assert.assertEquals(errorMesage, actualTxt);
	  
	}
	@Then("I should not be directed to password field.")
	public void i_should_not_be_directed_to_password_field() {
	 Assert.assertTrue(amz.emailPhone.isDisplayed());
	}

}
