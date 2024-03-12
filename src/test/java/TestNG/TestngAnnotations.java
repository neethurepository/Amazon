package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pOM.POMcontactus;
	//1. no main method
	//2.code in the testng is inside method
	//3.method is inside the annotation
	public class TestngAnnotations {
		 WebDriver driver;//to make driver and object reference POM accessible to all methods,so declared globally
		 POMcontactus POM;
		//refer program contactus and POMcontacts
		 
		@BeforeMethod
        public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver =new ChromeDriver();
		driver.get("https://www.roicians.com/contact-us/");
	    //create the Object of POM class, so we can use all the methods and variables
		POM=new POMcontactus(driver);//calling the constructor
		}
		
		@Test(priority=1) //this test case will be executed first
		public void validcase() throws InterruptedException { //test case
		POM.typefirstname("Neena");
		Thread.sleep(3000);
	}
		@Test(priority=2) //this test case will execute second
		public void invalidcase() { //test case
		POM.typelastname("sun");
		}

	    @AfterMethod
		public void closebrowser() { //execute after test case
		driver.close(); 
		}
	}



