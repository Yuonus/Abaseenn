package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonSearchPages {
	
	public AmazonSearchPages() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-discoverability-t1']")
	public WebElement flag;
	
	@FindBy (xpath = "//input[@type='text']")
	public WebElement search;
	
	@FindBy (id = "nav-search-submit-button")
	public WebElement searchBtn;
	
	@FindBy (xpath = "//span[@class='a-color-state a-text-bold']")
	public WebElement searchTxt;
	
	
	

}
