package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SauceDemoPages {
	
	public SauceDemoPages() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (css = ".bot_column")
	public WebElement homepage;
	
	@FindBy (xpath = "//input[@placeholder='Username']")
	public WebElement userName;
	
	@FindBy (css = "#password")
	public WebElement password;
	
	@FindBy (id = "login-button")
	public WebElement login;
	
	@FindBy (css = ".peek")
	public WebElement sauceLoginPage;
	
	@FindBy (css = ".inventory_item_description")
	public List<WebElement> items;
	
	@FindBy (xpath = "//h3[@data-test='error']")
	public WebElement errorTxt;
	

}
