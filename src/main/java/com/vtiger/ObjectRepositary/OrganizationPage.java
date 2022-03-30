package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author saraswata
 * 
 */

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement clickOnAddIcon;
	
	public WebElement getclickOnAddIcon() {
		return clickOnAddIcon;
		
	}
	public void addOrganization() {
		clickOnAddIcon.click();
	}
		
		

}
