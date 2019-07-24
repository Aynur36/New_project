package Vytrack.step_definition;

import java.awt.Desktop.Action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Vytrack.pages.homePage;
import Vytrack.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class homePageStep_Definition {


	Actions action;
	homePage page = new homePage();


	@Given("i am on Vytrack homepage")
	public void i_am_on_Vytrack_homepage() throws InterruptedException {

		

		 Thread.sleep(3000);

		 Driver.getDriver().manage().window().maximize();

		 String title = Driver.getDriver().getTitle();

		 System.out.println(title);

		 Assert.assertEquals("Dashboard", title);



	}



	@When("i hover my mouse to Fleet header")
	public void i_hover_my_mouse_to_Fleet_header() throws InterruptedException {



		 action = new Actions(Driver.getDriver());

		action.moveToElement(page.Fleet).perform();

	}



	@When("i click on Vehicle Odometer")
	public void i_click_on_Vehicle_Odometer() {

		page.VehicleOdemeter.click();
	
	}



	@Then("i should see Vehicle Odometer page")

	public void i_should_see_Vehicle_Odometer_page() throws InterruptedException {

		Assert.assertTrue(page.VehicleOdometorPage.isDisplayed());
		Thread.sleep(2000);
	}



	@Then("i click on the create vehicle odometer section")
	public void i_click_on_the_create_vehicle_odometer_section() throws InterruptedException {

		page.CreateVehicleOdometerButton.click();
		Thread.sleep(2000);

	}



	@Then("i see create vehicle odometer page")
	public void i_see_create_vehicle_odometer_page() throws InterruptedException {

	

		Assert.assertTrue( page.CreateVehicleOdometerPage.isDisplayed());

		

	}



	@Then("i fill all blanks and click on Add")
	public void i_fill_all_blanks_and_click_on_Add() throws InterruptedException {

		

		page.OdometerValue.sendKeys("32,500");

		page.DateClick.click();

		page.Date.click();

		page.Drivers.sendKeys("Babur");

		page.UnitBox.click();

		page.Unit.click();

		Thread.sleep(3000);

		page.Add.click();

		Thread.sleep(3000);

		page.checkBox.click();

		page.select.click();

       Driver.closeDriver();

	}
	
	
	
	
	//secend step
	
	@When("i click on Vehicle")

	public void i_click_on_Vehicle() throws InterruptedException {

	    page.Vehicles.click();

	    Thread.sleep(3000);

	    String title = Driver.getDriver().getTitle();

	    Assert.assertTrue(title.contains("Car - Entities"));

	    //expected title = Car - Entities
	}
	

	@When("i click on any driver")
public void i_click_on_any_driver() throws InterruptedException {

		

		page.driverName.click();

		Thread.sleep(3000);

		String title = Driver.getDriver().getTitle();

		Assert.assertTrue(title.contains("John Doe"));

		//John Doe
	    
	}

	@Then("System should display general info of the Vehicle")

	public void system_should_display_general_info_of_the_Vehicle() {

	 

		Assert.assertTrue(page.GeneralInfoHeader.isDisplayed());

	}
	





@When("i delete the any vehicle odometer")
public void i_delete_the_any_vehicle_odometer() throws InterruptedException { 

         Thread.sleep(3000);

 		 action = new Actions(Driver.getDriver());

 		 action.moveToElement(page.barHolder).perform();
 		Thread.sleep(3000);
 		//page.deletedButton.click();
}
 		








@Then("the vehicle odometer should be deleted")
public void the_vehicle_odometer_should_be_deleted() {
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

}



