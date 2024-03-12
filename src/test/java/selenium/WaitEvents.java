package selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitEvents {

	public static void main(String[] args) {
		
		//to open browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
      //implicit wait-for the elements on the web page
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		// to open url of contact us page of Roicians
		 driver.get("https://www.roicians.com/contact-us/");
		 
		 //Explicit Wait
		 
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 //wait until the element is visible(first name from contact us page)
		 // pass the value in the same line itself
		 //wait.until(ExpectedConditions.(null))
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text-77525447616"))).sendKeys("Neethu");
		 
		 //If you are storing any element locator in a variable data type is WebElement
		 
		 //WebElement fname =	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text-77525447616")));
		 //fname.sendKeys("Neethu");
		 
		 
		 //Fluent Wait
		 //In WebDriver I need to implement fluent wait,and also specify the object reference variable,
		 //where wait is 30 seconds and check the element after every 10ms, and also ignore no such element exception if
		 // couldn't find the element in 10ms.
		 
		 Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(30))
				 .pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class);
		 
		WebElement lname= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("text-95374915097")));
		lname.sendKeys("Sunny");
		 
		 
	}

}
