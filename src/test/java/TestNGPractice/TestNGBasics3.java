package TestNGPractice;


	


	import org.testng.annotations.Test;

	public class TestNGBasics3 {
		
		@Test
		public void loginTest() {
			System.out.println("Login Test");
			//int i=9/0; //login test will be failed so all depended test will be failed
		}
		
		@Test(dependsOnMethods ="loginTest") //HomePageTest will be ignored/skipped because it is depended on login test.Since login test is failed
		public void homePageTest() { //because no point of executing homepage test since login test is failed
			System.out.println("HomePage Test");
		}
		
		@Test(dependsOnMethods ="loginTest") //SearchPage will be skipped because it is depended on LOgin tEst
		public void searchPage() {
			System.out.println("search Page");
		}
		@Test(dependsOnMethods ="loginTest") ////Registration page will be skipped because it is depended on LOgin tEst
		public void registrationPage() {
			System.out.println("Registration Page");
		}
		
		
	}


