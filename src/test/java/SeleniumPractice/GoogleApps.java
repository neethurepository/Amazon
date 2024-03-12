package SeleniumPractice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleApps {

	public static void main(String[] args) throws InterruptedException {
		//Open Browser
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver driver=new ChromeDriver();
 				driver.get("https://www.google.com/");
         //open Apps,print the list of apps in it
				driver.findElement(By.cssSelector("#gbwa > div > a")).click();
				//switch to frame
				
				driver.switchTo().frame("app");
				Thread.sleep(3000);
      List<WebElement>  allApps=  driver.findElements(By.xpath("//div[@class='LVal7b ']/ul/li"));
      System.out.println(allApps.size());
     
      
     //print the list of apps
      for(int i=0;i<allApps.size();i++) { //the links can be printed using the for loop
	    	System.out.println(allApps.get(i).getText());
	    
      }
      driver.switchTo().defaultContent();
      Thread.sleep(1000);
  	
      driver.findElement(By.xpath("//input[@placeholder='Search Google or type a URL']")).sendKeys("Helen of Sparta");
    
      driver.close();

	}}
