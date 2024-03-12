package TestNGPractice;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Assertions6 {
		
	WebDriver driver;
		
		@BeforeMethod //all prerequistes in before method
		public void setUp() {

			 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 
			 driver=new ChromeDriver();//launch chrome
			 
			 driver.manage().window().maximize();
			 
			 driver.manage().deleteAllCookies();
			 
			 driver.manage().timeouts().pageLoadTimeout( 40, TimeUnit.SECONDS);
			 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 driver.get("http://www.google.com");
		      }
			 
		@Test()
		public void googleTitletest() {
			
			String title=driver.getTitle();
			System.out.println(title);
			
			//validate the title
			//we have to use validations in the form of assertions
			//title--is the actual value
			//Google--is the expected value
			//if assertion failed print --"title is not matched"
			Assert.assertEquals(title, "Google", "title is not matched");
		
			
			
		}
		@Test()
		public void googleLogoTest()
		{
		boolean b=	driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]")).isDisplayed();
		Assert.assertTrue(b);//we are expecting true for the logo,checks the logo is displayed or not
			
		}
		
	    @AfterMethod
		
		public void tearDown() {
			
			driver.quit();
			
			
		}
	}



