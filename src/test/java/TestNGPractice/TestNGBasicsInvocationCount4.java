package TestNGPractice;

import org.testng.annotations.Test;

public class TestNGBasicsInvocationCount4 {
	@Test(invocationCount=10)//the testcase will be executed 10 times as per our requirement
	public void sum() {
		
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println("sum is"+c);
	}

}

