package TestNGPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestExcel8 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	}
	
	
	
	@Test(dataProvider="getData")//this test case will executed 4 times with 4 different set of data
	public void loginTest(String user,String pwd, String exp) { //pass the parameters as per the data providers
		
	driver.get("https://admin-demo.nopcommerce.com/login");	
	
	WebElement txtEmail=driver.findElement(By.id("Email")); //email
	txtEmail.clear();
	txtEmail.sendKeys(user);
	

	WebElement txtPassword=driver.findElement(By.id("Password"));//password
	txtPassword.clear();
	txtPassword.sendKeys(pwd);
	
	driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click(); //login button
	String exp_title="Dashboard / nopCommerce administration";
	String act_title=driver.getTitle();
	
	if (exp.equals("valid")) {
		if (exp_title.equals(act_title)) {
			driver.findElement(By.linkText("Logout")).click();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}}
	
	
	else if(exp.equals("invalid")) {
		if (exp_title.equals(act_title)) {
			driver.findElement(By.linkText("Logout")).click();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}}
	
	}
	
	
	//Creating Data Provider to provide multiple set of data
	@DataProvider(name="getData")
	public String[][] login(){
		String loginData[][]= {
				{"admin@yourstore.com","admin","valid"},
				{"admin@yourstore.com","adm","invalid"},
				{"adm@yourstore.com","admin","invalid"},
				{"adm@yourstore.com","adm","invalid"},
				
		};
		return loginData;
	
	}
@AfterClass()
public void closeBrowser() {
	driver.close();
}
}
