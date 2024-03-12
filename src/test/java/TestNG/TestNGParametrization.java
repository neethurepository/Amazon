package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGParametrization {
	WebDriver driver;
	@BeforeSuite //first thing to execute, and it execute only once
	public void driversetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	
   @BeforeMethod //execute before every test case
   public void before() {
	driver=new ChromeDriver();
   	driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
   	driver.get("https://www.google.com/");

   	
   }
   	@DataProvider(name="getData")//for providing mutliple test data, name of the data provider is getData
   	//method will return object[][]2-dimensional array
   	public Object[][] search(){
		return new Object[][]{{"Roicians"},{"Roicians Automation Testing"},{"Roicians QA"}};
   		//returning object array,(object of object array), in the curly braces write the multiple set of data
   	}
   	
   @Test(dataProvider="getData")//In order provide the dataprovider test data, in this testcase,provide the name of dataprovider
   public void display(String keywords) throws InterruptedException {//parameter is String because, the test data is String
	   //find the locator for search bar in Google,pass the testdata as keywords
	   driver.findElement(By.cssSelector("#APjFqb")).sendKeys(keywords);
	   Thread.sleep(1000);
   }
   @AfterMethod
   public void after() {
	   driver.close();
   }
}
