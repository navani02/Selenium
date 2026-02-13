package org.pom;

import org.openqa.selenium.WebElement;
import org.reuse.BaseClass;

public class PomConcept extends BaseClass {
	public static void main(String[] args) {
		openChrome();
		launchUrl("https://www.facebook.com");
		
		POJOLogin p = new POJOLogin();
		
		WebElement emailTxt = p.getEmailTxt();
		passValue(emailTxt, "Java");
		
		WebElement passBx = p.getPassTxt(); 
		passValue(passBx, "1234");
		
		driver.navigate().refresh();
		
		
		passValue(emailTxt, "Selenium");
		
		passValue(passBx, "12345"); 
		
		
		

				
	}
	

}
