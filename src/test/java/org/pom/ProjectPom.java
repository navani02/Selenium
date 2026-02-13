package org.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.reuse.BaseClass;
import org.test.ProjectPojoPom;
import org.test.ProjectPojoPom1;
import org.test.ProjectPojoPom2;
import org.test.ProjectPojoPom3;

public class ProjectPom extends BaseClass {
	public static void main(String[] args) throws InterruptedException, IOException {
		openChrome();
		launchUrl("https://www.prettylittlething.com/");
		
		ProjectPojoPom p = new ProjectPojoPom();
		
		
		WebElement acceptCookies = p.getAcceptCookies();
		clickElement(acceptCookies);
		
		WebElement account = p.getAccount();
		clickElement(account);
		
		captureScreenshot("screenshot1");
		
		
		ProjectPojoPom1 p1 = new ProjectPojoPom1();
		
		WebElement emailTxt = p1.getEmailTxt();
		passValue(emailTxt, "navani02@gmail.com");
		
		WebElement passTxt = p1.getPassTxt(); 
		passValue(passTxt, "King@123"); 
		
		WebElement lgnBtn = p1.getLgnBtn(); 
		clickElement(lgnBtn);
		
		captureScreenshot("screenshot2");  
		
		ProjectPojoPom2 p2 = new ProjectPojoPom2();
		
		WebElement coat = p2.getCoat();   
		clickElement(coat);
		
		WebElement selDress = p2.getSelDress(); 
		clickElement(selDress); 
		
		captureScreenshot("screenshot3");
		
		
		ProjectPojoPom3 p3 = new ProjectPojoPom3();
		
        WebElement selSize = p3.getSelSize(); 
		clickElement(selSize);
		
		WebElement addTobag = p3.getAddTobag(); 
		clickElement(addTobag);
		
		ThreadSleep();
		captureScreenshot("screenshot4"); 
		

				
	}

}
