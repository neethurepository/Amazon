package pOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Contactus {

	public static void main(String[] args) {
     	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//give the location of chromedriver.exe file
	    WebDriver driver=new ChromeDriver();
		driver.get("https://www.roicians.com/contact-us/");//using get method to open url
		
		
		//we have stored all the element locators and actions to be performed on the locators in POM
		//since POM, does not have main method, it can can accessed globally
		
	 //create the Object of POM class, so we can use all the methods and variables
	POMcontactus POM=new POMcontactus(driver);//calling the constructor
	POM.typefirstname("Neethu");
	POM.typelastname("Sunny");
	POM.typeemail("nee@hotmail.com");
	POM.typephonenumber("8990002727");
	POM.typemessage("I am Neethu Sunny");
	POM.clicksend(null);

	}

}
