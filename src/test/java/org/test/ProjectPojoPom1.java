package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reuse.BaseClass;

public class ProjectPojoPom1 extends BaseClass {
	
	public ProjectPojoPom1() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "login-email")
	private WebElement emailTxt;
	
	@FindBy(id = "login-password") 
	private WebElement passTxt;  
	
	
	@FindBy(xpath = "//div[text()='Sign In']")  
	private WebElement lgnBtn;
	
	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPassTxt() {
		return passTxt;
	}

	public WebElement getLgnBtn() {
		return lgnBtn;
	}
	

}
