package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//1. no main method
//2.code in the testng is inside method
//3.method is inside the annotation

public class TestngSample {
	@BeforeMethod
	public void openbrowser() { //execute before test case
		System.out.println("4-10 charaters");
	}
	
	@Test(priority=1) //this test case will be executed first
	public void validcase() { //test case
	System.out.println("4-10 characters");
}
	@Test(priority=2) //this test case will execute second
	public void invalidcase() { //test case
	System.out.println("less than 4 characters");
	}

    @AfterMethod
	public void closebrowser() { //execute after test case
		System.out.println("close browse"); 
	}
}
