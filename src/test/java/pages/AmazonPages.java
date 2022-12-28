package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPages {
	
	public AmazonPages() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	public WebElement signInBtn;
	
	@FindBy (id = "createAccountSubmit")
	public WebElement createAcc;
	
	@FindBy (xpath = "//input[@maxlength='128']")
	public WebElement emailPhone;
	
	@FindBy (css = ".a-button-input") 
	public WebElement contBtn;
	
	@FindBy (css = ".a-list-item")
	public WebElement errorMsg;
}
