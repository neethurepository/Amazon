                                                                                        package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPage {

	public static void main(String[] args) {
     	//step1: to open browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//give the location of chromedriver.exe file
		
		//step2: to open url
		
		//Inorder to use all the emthods of ChromeDriver class create object of the class
		//ChromeDriver driver=new ChromeDriver();
		
		//Webdriver is an interface which is implemented by all other browsers
		//child class object is refered by Parents class reference variable is 
	     WebDriver driver=new ChromeDriver();//top casting
		driver.get("https://www.walmart.ca/sign-in");//using get method to open url
		
		//step 3: type email
		//inspect the elelment and using the locator find the element
		//sendkeys is used to type values
		driver.findElement(By.id("react-aria-1")).sendKeys("neethu3006@gmail.com");
		
		//step 4:click on Continue                                                                                                                                                                                                                        
		
		driver.findElement(By.id("login-continue-button")).click();
		

	}

}
                                                                               