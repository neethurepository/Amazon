package selenium;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestLogger {

	public static WebDriver driver;
	public static Logger log;
	public static void main(String[] args) throws InterruptedException {
		
		log= LogManager.getLogger(TestLogger.class);
	    
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		log.info("logged into google");
		
		//click on About,Store
		
		driver.findElement(By.linkText("About")).click();//in About page
		Thread.sleep(2000);
		
		log.info("clicked on About link");
		driver.navigate().back();//back to Google page
		
		log.info("back to google page");
		
		driver.findElement(By.linkText("Store")).click();
		
		log.info("click on link store");
		driver.navigate().back();
		log.info("logged back to google");
		Thread.sleep(3000);
		//get Title
		
	String a=	driver.getTitle();
	System.out.println(a);
	log.info("get the title of page");
	
    // Is Gmail link present 
	boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	System.out.println(b);
	log.info("check gmail link is displayed");
		

    
		driver.close();

	}
}

