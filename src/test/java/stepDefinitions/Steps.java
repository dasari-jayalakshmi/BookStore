package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.BookStorePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class Steps {

	WebDriver driver;
	public LoginPage loginPage;
	public ProfilePage profilePage;
	public BookStorePage bookStorePage;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		profilePage = new ProfilePage(driver);
		bookStorePage = new BookStorePage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@Then("I should see a login button with the text {string}")
	public void i_should_see_a_login_button_with_the_text(String loginButtonText) {
		String response = loginPage.getLoginButtonText();
		Boolean match = response.equalsIgnoreCase(loginButtonText);
		Assert.assertTrue(match);
		driver.close();
	}

	@Then("I should see a Newuser button with the text {string}")
	public void i_should_see_a_newuser_button_with_the_text(String newUserButtonText) {
		String response = loginPage.getNewUserButtonText();
		Boolean match = response.equalsIgnoreCase(newUserButtonText);
		Assert.assertTrue(match);
		driver.close();
	}

	@Then("It should have header with the text {string}")
	public void it_should_have_header_with_the_text(String headerText) {
		String title = loginPage.getHeaderText();
		Boolean match = title.equalsIgnoreCase(headerText);
		Assert.assertTrue(match);
		driver.close();
	}

	@Then("It should have left panel")
	public void it_should_have_left_panel() {
		Boolean response = loginPage.isLeftPanelVisible();
		Assert.assertTrue(response);
		driver.close();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		loginPage.setUserEmailAddress(email);
		loginPage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPage.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String string) throws InterruptedException {
		Thread.sleep(3000);
		String profilePageTitle = profilePage.getHeaderText();
		Boolean match = profilePageTitle.equalsIgnoreCase(string);
		Assert.assertTrue(match);
		driver.close();
	}

	@When("User enters Email as {string} and wrong Password as {string}")
	public void user_enters_email_as_and_wrong_password_as(String string, String string2) {
		loginPage.setUserEmailAddress(string);
		loginPage.setPassword(string2);
	}

	@Then("It should display error message as {string}")
	public void it_should_display_error_message_as(String string) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String errorMessage = loginPage.getErrorMessage();
		Boolean match = errorMessage.equalsIgnoreCase(string);
		Assert.assertTrue(match);
		driver.close();
	}

	// Profile Page
	@Then("I can see {string} button and {string} button and {string} button")
	public void i_can_see_button_and_button_and_button(String logOutButtonText, String string2, String string3)
			throws InterruptedException {
		Thread.sleep(3000);
		String text1 = profilePage.getLogoutButtonText();
		Boolean matchLogOutButtonText = text1.equalsIgnoreCase(logOutButtonText);
		Assert.assertTrue(matchLogOutButtonText);
		driver.close();
	}

	@When("user click on DeleteAllBooks button")
	public void user_click_on_delete_all_books_button() throws InterruptedException {
		profilePage.clickOnDeleteAll();
	}

	@Then("it should display deleteAllBooksPopUp")
	public void it_should_display_delete_all_books_pop_up() {
		String popupMessage = profilePage.getDeleteAllBooksPopUpMessage();
		Boolean match = popupMessage.equalsIgnoreCase("Do you want to delete all books?");
		Assert.assertTrue(match);
	}

	@Then("user click on OkayButtonOnDeleteAllBooksPopUp")
	public void user_click_on_okay_button_on_delete_all_books_pop_up() {
		profilePage.clickOkOnDeleteAllPopUp();
	}

	@Then("it should delete all books in the collection")
	public void it_should_delete_all_books_in_the_collection() {
		String text = profilePage.getNoRowsFoundText();
		Boolean match = text.equalsIgnoreCase("No rows found");
		Assert.assertTrue(match);
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() {
		profilePage.clickLogout();
	}

	@Then("it should redirect the user to login page")
	public void it_should_redirect_the_user_to_login_page() {
		String currentUrl = driver.getCurrentUrl();
		Boolean match = currentUrl.equalsIgnoreCase("https://demoqa.com/login");
		Assert.assertTrue(match);
	}

	// BookStore page

	@Then("can see list of books")
	public void can_see_list_of_books() {
		String bookStoreHeaderText = bookStorePage.getHeaderText();
		Boolean match = bookStoreHeaderText.equalsIgnoreCase("Book Store");
		Assert.assertTrue(match);
		driver.close();
	}

	@Then("enter {string} in search box")
	public void enter_in_search_box(String searchString) {
		bookStorePage.setSearchString(searchString);
	}

	@Then("it should display {string} book in results")
	public void it_should_display_book_in_results(String nameOfTheBook) {
		String bookName = bookStorePage.getFilteredBookName();
		Assert.assertEquals(bookName, nameOfTheBook);
		driver.close();
	}

	@Then("user click book with name {string}")
	public void user_click_book_with_name(String bookName) {
		bookStorePage.setSearchString("");
		bookStorePage.clickBookByName(bookName);
	}

	@Then("it should show book details page")
	public void it_should_show_book_details_page() {
		String ISBN = bookStorePage.getISBN();
		Assert.assertEquals(ISBN, "9781449325862");
		driver.close();
	}

	@Then("user click on AddToYourCollection button")
	public void user_click_on_add_to_your_collection_button() {
		bookStorePage.clickAddToYourCollection();

	}

	@Then("it should display popupMessage {string}")
	public void it_should_display_popup_message(String string) {
		String alertText = bookStorePage.getAlertMessageText();
		Assert.assertEquals(alertText, "Book added to your collection.");
		bookStorePage.clickOnAlertMessage();
		driver.close();
	}
}
