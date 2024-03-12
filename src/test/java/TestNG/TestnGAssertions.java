package TestNG;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestnGAssertions {
	WebDriver driver;
    SoftAssert obj;
	@BeforeSuite //first thing to execute, and it execute only once
	public void driversetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	

    @BeforeTest//execute only once before the first the first test case
    public void initalsetup() {
    	
    }
   @BeforeMethod //execute before every test case
   public void before() {
	driver=new ChromeDriver();
   	driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	driver.get("https://www.google.com/"); 
    obj=new SoftAssert();
   }
   
   
   @Test(priority=1,groups="title") //by default testNG execute test case alphabetically based on method
   //enabled=false will skip the getTitle test case, so depended method gmailDisplayed will also be skipped
   public void getTitle() {
	String title=   driver.getTitle();
	System.out.println(title);
	//Hard Assert
	//Assert.assertEquals(title, "yahoo.com");
	
	//Soft assert-->to check if the expected and actual are same
	obj.assertEquals(title, "Googlae");//actual and expected are not same
	driver.close();//In soft assert,even if the expected and actual are not same,other code will be executed
	obj.assertAll();//In order to display the failure, we have to use this

   }
   
   @Test(priority=2,groups="verification",dependsOnMethods= {"getTitle" })//groups can be used to specify which functionality does this test case belong
   //if the getTitle test case fails,gmailDisplayed() will be skipped,because gmail displayed is depended on gettitle
   //check gmail link is displayed or not
   public void gmaildisplayed() {
   boolean a= driver.findElement(By.linkText("Gmail")).isDisplayed();//is Displayed returns boolean value

   Assert.assertTrue(a);
   }
   
   

	  
   }
   
   

