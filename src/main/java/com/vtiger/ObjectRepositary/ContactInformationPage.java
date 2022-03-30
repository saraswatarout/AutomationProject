package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements( driver , this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement contactName;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement orgNameChoosed;
	
	public WebElement getOrgNameChoosed() {
	 return orgNameChoosed;
	}

	public WebElement getContactName() {
		return contactName;
	}
	public String readContactName() {
		String name=contactName.getText();
		return name;
	}
	public String readorganizationName() {
		String name=orgNameChoosed.getText();
		return name;
	}
}
	