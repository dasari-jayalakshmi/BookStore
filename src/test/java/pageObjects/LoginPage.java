package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driverObject){
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
	}
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(id="newUser")
	WebElement newUserButton;
	
	@FindBy(id="userName")
	WebElement inputUserName;
	
	@FindBy(id="password")
	WebElement inputPassword;
	
	@FindBy(className="main-header")
	WebElement header;
	
	@FindBy(className="left-pannel")
	WebElement leftPanel;
	
	@FindBy(id="output")
	WebElement outputMessage;
	
	public void setUserEmailAddress(String email) {
		inputUserName.clear();
		inputUserName.sendKeys(email);
	}
	
	public void setPassword(String password) {
		inputPassword.clear();
		inputPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public String getLoginButtonText() {
		return loginButton.getText();
	}
	
	public String getNewUserButtonText() {
		return newUserButton.getText();
	}
	
	public String getHeaderText() {
		return header.getText();
	}
	
	public boolean isLeftPanelVisible() {
		return leftPanel.isDisplayed();
	}
	
	public String getErrorMessage() {
		return outputMessage.getText();
	}
}
