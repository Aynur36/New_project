package Vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vytrack.utilities.Driver;

public class LoginPage {

	
	public LoginPage() {
		
		PageFactory.initElements(Driver.getDriver(),this);
		
	}

     @FindBy(id = "prependedInput")
     public WebElement username;
     
     
     @FindBy(id = "prependedInput2")
     public WebElement password;
     
     
     @FindBy(id ="_submit")
     public WebElement login;
     
     
} 
