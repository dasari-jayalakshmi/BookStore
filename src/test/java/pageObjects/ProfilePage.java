package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	public WebDriver driver;
	WebDriverWait w;
	
	public ProfilePage(WebDriver driverObject){
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
		w = new WebDriverWait(driver,3);
	}
	
	@FindBy(id="submit")
	WebElement logoutButton;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/button[1]")
	WebElement goToStoreButton;
	
	@FindBy(className="main-header")
	WebElement header;
	
	@FindBy(id="searchBox")
	WebElement inputSearchBox;
	
	@FindBy(className="left-pannel")
	WebElement leftPanel;
	
	By Header=By.className("main-header");
	
	public String getHeaderText() {
		waitForProfilePage();
		return header.getText();
	}
	
	public void waitForProfilePage() {
		 w.until(ExpectedConditions.presenceOfElementLocated (Header));
	}
	
	public String getLogoutButtonText() {
		return logoutButton.getText();
	}
	
	public void gotoBookStore() {
//		 goToStoreButton.click();
		driver.get("https://demoqa.com/books");
		 
	}
}
