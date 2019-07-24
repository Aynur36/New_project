import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

		
		public class porshe718 {
			static WebDriver driver;
			static List<Double> totalEquipPrice;
			static double basePrice;
			JavascriptExecutor executor;

			public static boolean verifyTPrice(double basePrice) {
				String equipPrice = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
				double ePrice = price(equipPrice);

				String delivPrice = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText();
				double dPrice = price(delivPrice);

				String totalPrice = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText();
				double tPrice = price(totalPrice);

				if (tPrice == dPrice + basePrice + ePrice) {
					return true;
				} else {
					return false;
				}
			}

			public static boolean verifyEPrice(WebElement searchElement) {
				String strPrice = searchElement.getText(); //every webElement has located in diff methods relative to its price/section
				double Price = price(strPrice);
				totalEquipPrice.add(Price);

				String EquipPrice = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
				double EPrice = price(EquipPrice);

				double totalEPrice = 0;
				for (Double double1 : totalEquipPrice) { //adding it to the array and looping 
					totalEPrice += double1;
				}

				if (totalEPrice == EPrice) {
					return true;
				} else {
					System.out.println("FAIL: Total Equipment Price!=Total Equipment Expenses");
				}
				return false;
			}

			public static double price(String str) { // $ 56,900.00 -> 56900.00

				String temp = new String();

				for (int i = 0; i < str.length(); i++) {

					if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.') {

						temp += str.charAt(i) + "";
					}
				}

				return Double.parseDouble(temp);
			}

			@BeforeClass
			public void setUp() {

				totalEquipPrice = new ArrayList<Double>();
				

				WebDriverManager.chromedriver().setup(); // BoniGarcia

				driver = new ChromeDriver(); // Opens Chrome Browser
				String url = "https://www.porsche.com/usa/modelstart/";
				driver.get(url); // Goes to url
				executor = (JavascriptExecutor) driver;

				driver.manage().window().maximize(); // Makes the browser window fullscreen
				driver.findElement(By.cssSelector("a[href='/usa/modelstart/all/?modelrange=718']")).click(); // tagName[attrName='value']
			}

			@Test
			public void verify_Base_Price() {

				String strBasePrice = driver.findElement(By.cssSelector("div[class='m-14-model-price']")).getText(); // saves
																														// the
																														// price
																														// of
																														// the
																														// 718
																														// Cayman

				basePrice = price(strBasePrice);
				driver.findElement(By.cssSelector("div[class='m-14-quick-link']")).click(); // clicks on Build & Price

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String parentWindow = driver.getWindowHandle();
				Set<String> handles = driver.getWindowHandles();
				for (String windowHandle : handles) {
					if (!windowHandle.equals(parentWindow)) {
						driver.switchTo().window(windowHandle);
					}
				}

				String strNBasePrice = driver.findElement(By.xpath("//section[@id='s_price']//div[@class='ccaRow']")).getText();
				double nBasePrice = price(strNBasePrice);
		 
				Assert.assertEquals(basePrice, nBasePrice);

			}

			@Test (dependsOnMethods= {"verify_Base_Price"}) //we can use priority =1, 2 etc
			public void verify_Equip_Price_Is_Zero() {

				String equipPrice = driver.findElement(By.xpath("//section[@id='s_price']//div[@class='ccaRow'][2]")).getText();
				double ePrice = price(equipPrice);

				Assert.assertEquals(0.0, ePrice);
			}

			@Test (dependsOnMethods= {"verify_Base_Price","verify_Equip_Price_Is_Zero"})
			public void verify_Initial_Total_Price() {

				Assert.assertTrue(verifyTPrice(basePrice));

			}

			@Test  (dependsOnMethods= {"verify_Initial_Total_Price"})
			public void verify_Color_Price() {

				driver.findElement(By.cssSelector("span[style='background-color: rgb(0, 120, 138);']")).click();
				WebElement ColorPElement = driver.findElement(By.xpath("//div[@class='tt_row']/div[@style='visibility: visible;']"));

				Assert.assertTrue(verifyEPrice(ColorPElement));
				Assert.assertTrue(verifyTPrice(basePrice));

			}

			@Test (dependsOnMethods= {"verify_Color_Price"})
			public void verify_Rim_Price() {

				WebElement element=driver.findElement(By.xpath("//ul[@class='tileWheels']/li[@data-price='$3,750']"));
				executor.executeScript("arguments[0].click();", element);
					
				WebElement RimPElement = driver.findElement(By.xpath("//*[@id='s_exterieur_x_IRA']/div[2]/div[1]/div/div[2]"));

				Assert.assertTrue(verifyEPrice(RimPElement));
				Assert.assertTrue(verifyTPrice(basePrice));
			}

			@Test (dependsOnMethods= {"verify_Rim_Price"})
			public void verify_Power_Seat_Price() {

				WebElement element = driver.findElement(By.id("s_interieur_x_PP06"));
				executor.executeScript("arguments[0].click();", element); 
				// use this when it is not clickable (constant, webElement you want to click)

				WebElement PowerSeatElement = driver.findElement(By.xpath("//*[@id=\"seats_73\"]/div[2]/div[1]/div[3]/div"));

				Assert.assertTrue(verifyEPrice(PowerSeatElement));
				Assert.assertTrue(verifyTPrice(basePrice));
			}

			@Test (dependsOnMethods= {"verify_Power_Seat_Price"})
			public void verify_Interior_Carbon_Fiber_Price() {
				WebElement interiorCFiber = driver.findElement(By.id("IIC_subHdl"));
				executor.executeScript("arguments[0].click();", interiorCFiber);

				WebElement iCFoption = driver.findElement(By.xpath("//*[@id=\'vs_table_IIC_x_PEKH_x_c01_PEKH\']"));
				executor.executeScript("arguments[0].click();", iCFoption);

				WebElement iCFP = driver.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH\"]/div[1]/div[2]/div"));

				Assert.assertTrue(verifyEPrice(iCFP));
				Assert.assertTrue(verifyTPrice(basePrice));

			}

			@Test (dependsOnMethods= {"verify_Interior_Carbon_Fiber_Price"}) 
			public void verify_PDK_PCCB_Price() {
				WebElement Performance = driver.findElement(By.id("IMG_subHdl"));
				executor.executeScript("arguments[0].click();", Performance);

				WebElement PDK = driver.findElement(By.id("vs_table_IMG_x_M250_x_c14_M250_x_shorttext"));
				executor.executeScript("arguments[0].click();", PDK);

				WebElement pdkP = driver.findElement(By.xpath("//*[@id=\'vs_table_IMG_x_M250\']/div[1]/div[2]/div"));
				Assert.assertTrue(verifyEPrice(pdkP));
				Assert.assertTrue(verifyTPrice(basePrice));

				WebElement PCCB = driver.findElement(By.id("vs_table_IMG_x_M450_x_c94_M450_x_shorttext"));
				executor.executeScript("arguments[0].click();", PCCB);

				WebElement pccbP = driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450\"]/div[1]/div[2]/div"));
				Assert.assertTrue(verifyEPrice(pccbP));
				Assert.assertTrue(verifyTPrice(basePrice));
			}

			@AfterClass 
			public void tearDown() {
				driver.quit();
			}

		}


		