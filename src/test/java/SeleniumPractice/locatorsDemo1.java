package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorsDemo1 {
	

		public static void main(String[] args) {
			 
	     System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	     
	     WebDriver driver= new ChromeDriver();
	     
	     driver.get(" http://automationpractice.com/index.php");
	     
	     driver.manage().window().maximize();
	     
	     //1.inspect search box and search for T-shirts using id attribute
	     //if we have multiple actiple actions on the element,instead of writing the same statement again and again
	     //we can store this to a variable of type WebElement
	     
	   WebElement searchbox=  driver.findElement(By.id("search_query_top"));
	   
	   searchbox.sendKeys("T-shirts");
	   
	   //2.click on the search button-using name attribute
	   
	     
	    driver.findElement(By.name("submit_search")).click();
	    
	    //3. when T-shirts is being saerched we get list of dress
	    //inspect the first option Printed Chiffon Dress using LinkText
	    //use click method to click on the item
	    
	    driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		 
	    
	    //4.using partial link text for the same "Printed Chiffon Dress"
	    //we need to pass only the portion of the link text
	    
	    //driver.findElement(By.partialLinkText(" Chiffon Dress")).click();
	    
	    //5.to find how many sliders are in the webpage
	    //first we need to find all the sliders and then we have to count them
	    //when we inspect the slider we can see,under ul-userlist we have li-list items
	    //li contains the sliders,under li- is ahref and under a-href is the image of th sliders
	    
	    //we need to find a common element that represent all the sliders
	    //use findelements because we are finding number of sliders-multiple elements
	    
	    int sliders=  driver.findElements(By.className("homeslider-container")).size();//gives the count of the sliders, store this in a int variable
	     
	     System.out.println(sliders);
	     
	     
	     //tagname
	     
	     //to find how many links are present in this webpage   
	     //link is associated with <a tag
	     //we have to find the common attribute(a)  for all the links, in that case we can go with the tag name
	     //use size method to find the number of links
	     
	     
	     
	    int links= driver.findElements(By.tagName("a")).size();//using findElements because we are getting multiple webelements
	     System.out.println(links);
		}
}
