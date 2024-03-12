package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DropDown {

	public static void main(String[] args) {
		
		//to open google chrome
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
	//inorder to use method of webdriver create object of the child class
	WebDriver driver=new ChromeDriver();
	
	//open roicians career url
	driver.get("https://www.roicians.com/career/");
	
	//from Job Title drop down we need to select Automation testing
	//for drop down we use select class
	//pass the locator of the element, whose options we need to chose in Select class
	
	Select obj=new Select(driver.findElement(By.id("field-jHhehcNamzHL47m")));//locator for Job Title
	
	//3 methods in select class
	
	//1.Select By visible Text
	//obj.selectByVisibleText("Automation Testing Trainer");
	
	//2.Select By Visible value
	//obj.selectByVisibleText("Automation Testing Trainer");
	
	//3.selectby Index
	//based on which option we need to choose
	obj.selectByIndex(3);
	
	

	}

}
