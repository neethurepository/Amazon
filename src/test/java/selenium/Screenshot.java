package selenium;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Screenshot {

	public static void main(String[] args) throws IOException {
		
		//to open browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		// to open url of contact us page of Roicians
		 driver.get("https://www.roicians.com/contact-us/");
		 
		 //to take screenshot of contact us page of roicians
		 //taking screenshot from the browser, and get the screenshot as a File,and store the screenshot in src file
		File srcFile=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Inorder to see the screenshot in our OS, use FileUtils to copy the screen shot from srcFile to the C Drive
		
		FileUtils.copyFile(srcFile, new File("C:/RoiciansScreenshot.jpg"));
		

	}

}
