package Vytrack.step_definition;



import Vytrack.pages.LoginPage;
import Vytrack.utilities.ConfigurationReader;
import Vytrack.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep_Definition {
	@Given("i am on Vytrack login page")
	public void i_am_on_Vytrack_login_page() {
		
	    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	    
		    
	}

	@Then("i login as sales manager")
	public void i_login_as_sales_manager() {
	    
		String username = ConfigurationReader.getProperty("username");
		String password = ConfigurationReader.getProperty("password");
		
		LoginPage page = new LoginPage();
		page.username.sendKeys(username);
		page.password.sendKeys(password);
		page.login.click();
		
	    
	}



}
