package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		//Open Browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//click on About,Store
		
		driver.findElement(By.linkText("About")).click();//in About page
		Thread.sleep(2000);
		driver.navigate().back();//back to Google page
		
		driver.findElement(By.linkText("Store")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		//get Title
		
	String a=	driver.getTitle();
	System.out.println(a);
	
    // Is Gmail link present 
	boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	System.out.println(b);
		

    
		driver.close();

	}

}