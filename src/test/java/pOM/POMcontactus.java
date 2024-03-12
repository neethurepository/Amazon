package pOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//storing all the eleement loctaors in a variable, so we can use variables in other class

public class POMcontactus {
WebDriver driver;	//POM is independent of the browser

//@-annotation
//@FindBy is a replacement of referencevariable.FindElement(By.)
//storing the element locators in a WebElement and name the element

@FindBy(id="text-77525447616")WebElement fname; //storing only the elements and not storing actions i.e., sendkeys
@FindBy(id="text-95374915097")WebElement lname;
@FindBy(id="text-27022866830")WebElement eml;
@FindBy(id="field-tIgxvmTMez6ibt1")WebElement phnnum;
@FindBy(id="field-kJfKGbPLNi5yFI7")WebElement msg;
@FindBy(id="button-18782068913")WebElement snd;

//In order to pass the value of local variable to global variable we need this keyword
//Also, we the variable name are same
// Create a constructor
		
   public POMcontactus(WebDriver driver) {
	   //@FindBy is a annotion of PageFactory class
	   
	PageFactory.initElements(driver, this);//(driver,this) local variable value is passed to global variable
}


//2.Create methods on all actions that can be performed on these elements

public void typefirstname(String firstname) { //name is always String
	//fname is the replacement of driver.findElement(By.id)
	fname.sendKeys(firstname);
	
}
public void typelastname(String lastname) {
	lname.sendKeys(lastname);
	
	
}
public void typeemail(String email) {
	eml.sendKeys(email);
	
	
}
public void typephonenumber(String phonenumber) {
	phnnum.sendKeys(phonenumber);
	
	
}
public void typemessage(String message) {
	msg.sendKeys(message);
}
public void clicksend(String send) {
		snd.click();
		
		
	}
	
	
}

