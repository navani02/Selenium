package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reuse.BaseClass;

public class ProjectPojoPom3 extends BaseClass {
	
	public ProjectPojoPom3() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='4']")  
	private WebElement selSize;
	
	@FindBy(xpath = "//span[text()='Add to bag']")  
	private WebElement addTobag;

    public WebElement getSelSize() {
		return selSize;
	}

	public WebElement getAddTobag() {
		return addTobag;
	}
	

}
