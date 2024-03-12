package TestNGPractice;

import org.testng.annotations.Test;

public class ExceptionTimeout5 {

	    //if Some testcase is stuck in a infinite loop or take time to execute the test case,we have timeout method,
		//timeOut=2000,the testcase should be executed within 2 seconds
		
		//to handle exceptions,we have exceptedExceptions 
		//this means we are expecting an exception,please dont fail the test case
		
			@Test(invocationTimeOut=2)
			public void infiniteLoopTest() {
				int i=1;
				
				while(i==1) {
					
					System.out.println(i);//since we are not incrementing the loop,1 will be printed infinite times 
				}
			}
			 @Test(expectedExceptions=NumberFormatException.class)	//when we use exceptedExceptions,the test case will be passed 
			 public void test1() {
				 String x="100A"; //Number format exception because x is a string
				 Integer.parseInt(x);
			 }
			
			
	}
			




