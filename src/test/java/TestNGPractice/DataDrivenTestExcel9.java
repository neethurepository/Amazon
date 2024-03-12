package TestNGPractice;

import java.io.IOException;
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

public class DataDrivenTestExcel9 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	}
	
	
	
	@Test(dataProvider="loginData")//this test case will executed 4 times with 4 different set of data
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
	@DataProvider(name="loginData")
	public String[][] login() throws IOException{
		//get data from Excel
		String path=".\\DataFiles\\loginData.xlsx"; //giving the path of Excel file ,.\\ means in the current project
		//Use XLUtility class methods to read data from Excel sheet
		
		XLUtility xlutils=new XLUtility(path);// pass the path as argument
		
		int totalrows=xlutils.getRowCount("Sheet1");//pass the name of the sheet, which returns row
		int totalcols=xlutils.getCellCount("Sheet1",1);//pass sheet name, any row number,whichreturns cols
		
		//with the same size, we have to create 2-dimensional arary,as soon as we read the data
		//from the excel we have to store the data in 2-dimensioal array and return the 2-dimensional array to the test case.
		
		String loginData[][]=new String[totalrows][totalcols];//two dimensional array created, same number of rows and cols in excel
		//and rows and cols in 2-dimensional array are same
		
		//Read the data from excel and store in 2-dimensional array
		//Since excel has header, we ignore the first row.so the data in [1][1] should go to [0][0] in 2-dimensional array
		//through loop statement pass the value to the 2-dimensional array
		
		for(int i=1;i<=totalrows;i++)//starting for i=1, because index 0 has the header
		{
			for(int j=0;j<totalcols;j++)//for all cells in a row
			{
				//get the cell data using XlUtility class method getCellData(), and store in 2-dimensional array
			loginData[i-1][j]=	xlutils.getCellData("Sheet1", i, j);//pass sheet name, rows and cols as parameter
				//i-1 because, in excel we are ignoring the first row and there is no changes to the col
			}
		}
		
		
		return loginData;
	
	}
@AfterClass()
public void closeBrowser() {
	driver.close();
}
}


