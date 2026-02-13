package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.reuse.BaseClass;

public class POJOLogin extends BaseClass{
	public POJOLogin() {
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(id = "email")
	private WebElement emailTxt;
	
	
	@FindBy(name = "pass")
	private WebElement passTxt; 
	
	
	@FindBy(xpath = "//button[text()='Log in']")  
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
