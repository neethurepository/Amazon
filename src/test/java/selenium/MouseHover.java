package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.roicians.com/");
		
		//for mouse movements we use Actions class
		Actions action=new Actions(driver);
		//mousehover courses and inspect courses 
		//Movetoelement will help to mouse hover
		action.moveToElement(driver.findElement(By.linkText("Courses"))).build().perform();
		
		//click on software testing
		
		driver.findElement(By.partialLinkText("SOFTWARE T")).click();
		
		//to close the driver after execution
		
		//driver.close();//to close the current tab
		driver.quit();// to close all the windows in a particular browser
	}

}
