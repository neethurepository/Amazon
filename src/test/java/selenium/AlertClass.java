package selenium;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class AlertClass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		//1.open the browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//2.open the url
		driver.get("https://demoqa.com/alerts");
		
		//3. Alert with one action
		  driver.findElement(By.id("alertButton")).click(); Thread.sleep(1000);
		  
		  //to switch to alert and assign to class Alert
		  Alert a=driver.switchTo().alert(); a.accept();//to click on OK
		
		
		//4. Alert with wait event
		
		  driver.findElement(By.id("timerAlertButton")).click();
		  //using Explicit wait for waiting for 5 seconds 
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
		  wait.until(ExpectedConditions.alertIsPresent());
		 
		  //switch to alert
		  Alert a1=driver.switchTo().alert();
		  a1.accept();//click on Ok
		
		 
		
		//5.Alert with 2 options
		driver.findElement(By.id("confirmButton")).click();
		//switch to alert
		Alert a2=driver.switchTo().alert();
		a2.dismiss();//dismiss for cancel
		
		//6.promt box- pass some value and click on Ok or cancel
		
		driver.findElement(By.id("promtButton")).click();
		Alert a3=driver.switchTo().alert();
		a3.sendKeys("hello");//pass value here
		a3.accept();//click Ok
		
		//Authentication pop-ups(Basic-Auth Pop ups)
		//passing username and password in the url itself, after the//,followed by@
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		
		System.out.println(width + height);
		
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyPress(KeyEvent.VK_A);
		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id("ID"));
		actions.contextClick(elementLocator).build().perform();

		

	}
}

