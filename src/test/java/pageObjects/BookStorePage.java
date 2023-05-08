package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStorePage {
	public WebDriver driver;
	WebDriverWait w;
	
	public BookStorePage(WebDriver driverObject){
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
		w = new WebDriverWait(driver,3);
	}
	
	@FindBy(id="submit")
	WebElement logoutButton;
	
	@FindBy(id="gotoStore")
	WebElement goToStoreButton;
	
	@FindBy(className="main-header")
	WebElement header;
	
	@FindBy(id="searchBox")
	WebElement inputSearchBox;
	
	@FindBy(className="left-pannel")
	WebElement leftPanel;
	
	@FindBy(xpath="//div[@id='ISBN-wrapper']//div[@class='col-md-9 col-sm-12']")
	WebElement isbnElement;
	
	@FindBy(id="addNewRecordButton")
	WebElement addNewRecordButton;
	
	By Header=By.className("main-header");
	
	By tableRows = By.className("rt-tr-group");
	
	public String getHeaderText() {
		waitForBookStorPage();
		return header.getText();
	}
	
	public void waitForBookStorPage() {
		 w.until(ExpectedConditions.presenceOfElementLocated (Header));
	}
	
	public String getLogoutButtonText() {
		return logoutButton.getText();
	}
	
	public void gotoBookStore() {
		 goToStoreButton.click();
	}

	public void setSearchString(String searchString) {
		inputSearchBox.sendKeys(searchString);
	}
	
	public String getFilteredBookName() {
		WebElement gitBook= driver.findElement(By.xpath("//a[normalize-space()='Git Pocket Guide']"));
		return gitBook.getText();
	}

	public void clickBookByName(String bookName) {
		WebElement book= driver.findElement(By.xpath("//a[normalize-space()='"+bookName+"']"));
		book.click();
	}

	public String getISBN() {
		return isbnElement.getText();
	}

	public void clickAddToYourCollection() {
		addNewRecordButton.click();
	}

	public String getAlertMessageText() {
		return driver.switchTo().alert().getText();
	}

	public void clickOnAlertMessage() {
		driver.switchTo().alert().accept();
	}
	
	
}
