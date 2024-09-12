package org.steps;

import java.awt.AWTException;

import org.baseclass.BaseClass;
import org.locators.HomePage;
import org.locators.LoginPage;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	
	@Given("the user opens the URL {string}")
	public void the_user_opens_the_url(String string) throws InterruptedException {
		browserLaunch("chrome");
		maximizeWindow();
		OpenAppUrl(string);
	
		HomePage userLink = new HomePage();
		Thread.sleep(5000);
		try {
			btnClick(userLink.getUserLoginLink());
		} catch (Exception e) {
			btnClick(userLink.getUserLoginLink());
		}
		implicitWait();
	}

	@When("the user enters the email {string} and the password {string}")
	public void the_user_enters_the_email_and_the_password(String username, String password) {
		LoginPage loginPage = new LoginPage();
		enterValue(loginPage.getTxtUserName(), username);
		enterValue(loginPage.getTxtPassword(), password);
	}

	@When("clicks on the Log In button")
	public void clicks_on_the_log_in_button() {
		LoginPage loginPage = new LoginPage();
		btnClick(loginPage.getBtnLogin());
	}

	@Then("the page navigates to the user dashboard screen")
	public void the_page_navigates_to_the_user_dashboard_screen() {
		System.out.println("Login Successfully");
	}

	@Then("an error validation message shows {string}")
	public void an_error_validation_message_shows(String string) {
	System.out.println(string);
	}

	@When("the user does not enter any credentials {string} and {string}")
	public void the_user_does_not_enter_any_credentials_and(String string, String string2) {
		System.out.println(string);
		System.out.println(string2);

	}

	@Then("error validation messages show {string} and {string}")
	public void error_validation_messages_show_and(String string, String string2) {
		System.out.println(string);
		System.out.println(string2);

	}

	@When("the user enters the username and password and press enter key")
	public void the_user_enters_the_username_and_password_and_press_enter_key(
			io.cucumber.datatable.DataTable dataTable) throws AWTException {
		LoginPage loginpage = new LoginPage();
		enterValue(loginpage.getTxtUserName(), getValue2DWithHeader(dataTable, 0, "username"));
		enterValue(loginpage.getTxtPassword(), getValue2DWithHeader(dataTable, 0, "password"));
		pressKey();
	}

}
