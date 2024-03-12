package TestNGPractice;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class TestNGBasics {
		
		
		//order of Execution
		
		@BeforeSuite //1
	    public void setup() {
	    System.out.println("setup system property for chrome");
		}
		
		@BeforeTest  //2
		 public void launchBrowser() {
		    System.out.println("launch Chrome Browser");
			}
		
		@BeforeClass //3
		 public void login() {
		    System.out.println("Login to app");
		    
		}
		
		
		@BeforeMethod//4  //7
		 public void enterUrlr() {
		    System.out.println("enter Url");
			}
		
		
		
		
		 @Test //5
		 public void googleTitleTest() {
	     System.out.println("Google Title Test");	 
		 }
		 
		 
		 @Test //8    //@Before Method and @After Method will be executed after every test casrs
		 public void searchTest() {
			 
			 System.out.println("search test");
		 }
		 
		 
		 @Test    //@Before Method and @After Method will be executed after every test casrs
		 public void googleLogoTest() {
			 
			 System.out.println("google logo test");
			 
		 }
		 
		 @AfterMethod //6 //9
		 public void logout() {
			 System.out.println("logout from the app");
		 }
		 
		 @AfterClass// 10
		 public void closeBrowser() {
			 System.out.println("close Browser");
		 
			}
		 
		 
		 @AfterTest// 11
		 public void deleteAllCookies() {
			 System.out.println("delete All Cookies");
		 
			}
		 
		
		 @AfterSuite  //12
		 public void generateReport() {
			 System.out.println("generate Report");
		 
			}
		 
		 
		 


	}

