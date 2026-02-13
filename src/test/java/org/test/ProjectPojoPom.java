package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reuse.BaseClass;

public class ProjectPojoPom extends BaseClass {
	public ProjectPojoPom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement acceptCookies;
	
	@FindBy(xpath = "//span[text()='Account'][2]")
	private WebElement account;
	
	public WebElement getAcceptCookies() {
		return acceptCookies;
	}

    public WebElement getAccount() {
		return account;
	}
	

	

}
