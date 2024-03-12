package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://demoqa.com/droppable");
	//Actions class is used to handle mouse movements
	
	Actions action=new Actions(driver);//pass the reference of Chrome driver
	action.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
	//location of source element, location of target element

	}

}
