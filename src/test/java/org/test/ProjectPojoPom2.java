package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reuse.BaseClass;

public class ProjectPojoPom2 extends BaseClass {
	
	public ProjectPojoPom2() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='COATS & JACKETS']")  
	private WebElement coat;
	
	@FindBy(xpath = "(//img[@class = 'analytics-tracking w-full object-cover transition-opacity duration-300'])[1]")  
	private WebElement selDress;
	
	public WebElement getCoat() {
		return coat;
	}

	public WebElement getSelDress() {
		return selDress;
	}
}
