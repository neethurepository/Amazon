package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationCommands {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		//to check if gmail is displayed or not
		driver.get("https://www.google.ca/");
		//.isdisplayed returns boolean value,store it in boolean ariable and display the result
		
		//customizing css selector
		//1. if you find class name, use .classname eg:classname=abc  i.e., .abc
		//2.if you find id ,use #id
		
    boolean result=driver.findElement(By.cssSelector(".gb_E")).isDisplayed();//.classname is used
    System.out.println(result);
    
    //isEnabled
    
    boolean result1=		driver.findElement(By.linkText("Gmail")).isEnabled();
    System.out.println(result1);
}
}