package TestNGPractice;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class DataProviderExcel7 {
		WebDriver driver;
		@BeforeMethod
		public void setup()

		{
	        System.setProperty("webdriver.chrome.driver", "C:\\Seleniumjars\\chromedriver.exe");
			 
			 driver=new ChromeDriver();//launch chrome
			 
			 driver.manage().window().maximize();
			 
			 driver.manage().deleteAllCookies();
			 
			 driver.manage().timeouts().pageLoadTimeout( 40, TimeUnit.SECONDS);
			 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2934&ru=");	
			
		}
		
		@Test
		public void halfEbayRegpageTest() {
			
			
		}
		
		
		@AfterMethod
		public void teardown() {
			driver.quit();
		}

	}


