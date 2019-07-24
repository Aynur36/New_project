package Vytrack.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vytrack.utilities.Driver;

public class homePage {

	

	

	public homePage() {

		PageFactory.initElements(Driver.getDriver(), this);

		}

	@FindBy(xpath = "//span[contains(text(),'Vehicle Odometer')]")

	public WebElement VehicleOdemeter;

	

	@FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Fleet')]")

	public WebElement Fleet ;

	

	@FindBy(className = "oro-subtitle")

	public WebElement VehicleOdometorPage ;

	

	@FindBy(xpath = "//a[contains(@class,'btn main-group btn-primary pull-right')]")

	public WebElement CreateVehicleOdometerButton ;

	

	@FindBy(xpath = "//h1[@class='user-name']")

	public WebElement CreateVehicleOdometerPage;

	

	@FindBy(xpath ="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[1]/div[2]/input[1]")

	public WebElement OdometerValue;

	

	@FindBy(xpath ="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/div[2]/input[1]")

	public WebElement DateClick ;

	

	@FindBy(xpath = "//a[contains(text(),'14')]")

	public WebElement Date;

	////tr[1]//td[2]//a[1]

	

	@FindBy(xpath ="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[3]/div[2]/input[1]")

	public WebElement Drivers ;

	

	

	@FindBy(xpath = "(//*[@class='select2-arrow'])[1]")

	public WebElement UnitBox;

	

	@FindBy(xpath = "//*[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")

	public WebElement Unit;

	

	@FindBy(xpath="//button[@class='btn btn-medium add-btn']")

	public WebElement Add ;

	

	@FindBy(xpath ="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable ui-resizable ui-dialog-normal ui-dialog-buttons']//tr[2]//td[1]")

	public WebElement checkBox ;

	

	@FindBy(xpath="//button[@class='btn btn-primary']")

	public WebElement select;
	
	

	@FindBy(xpath = "//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")
            public WebElement Vehicles;

	@FindBy(xpath= "//td[contains(text(),'John Doe')]")
		    public WebElement driverName	;
	
	@FindBy(xpath= "//td[contains(text(),'General Information')]")
	        public WebElement GeneralInfoHeader	;
	
	
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[5]")
           public WebElement barHolder ;
    
    
    @FindBy(xpath ="/html/body/div[4]")
    public WebElement deletedButton ;


}