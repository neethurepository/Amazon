package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) {
		//to open browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// to open url of contact us page of Roicians
		driver.get("https://www.roicians.com/contact-us/");//in roicians contact us page
		
		//navigate to another url
		driver.navigate().to("https://www.google.com/");//in google.com page
		
		//navigate back to roicians page
		driver.navigate().back(); //back in roicians contact us page
		
		driver.navigate().forward();//back to google page
		
		//to refresh a page
		
		driver.navigate().refresh();
		
		//driver.close();// close the current tab
		driver.quit();//close all the tabs in a browser
		
		
		

	}

}