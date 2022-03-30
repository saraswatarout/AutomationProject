package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.Genericutility.WebDriverUtility;
/**
 * Element repositary for createorganizationpage
 * @author saraswata
 */

public class CreateNewOrganizationPage {
	/* obect creation of webdriver utility */
	WebDriverUtility wUti=new WebDriverUtility();
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
    }
	@FindBy(name="accountname")
	private WebElement OrganizationNameTextField;
	
	@FindBy(name="industry")
	private WebElement IndustryType;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveOrganization;
	//all getter method for web element
	
	public  WebElement getOrganizationName() {
	return OrganizationNameTextField;
		 
	}
	
	public WebElement getIndustryType() {
		return IndustryType;
	}
	public WebElement getSaveOrganization() {
		return SaveOrganization;
	}
	/*all operation methods are mentioned below */
	
	/**
	 * This method will fill the organization name in to organization text field
	 * @param OrganizationName
	 */
	public void fillOrganizationName(String organizationPage) {
		OrganizationNameTextField.sendKeys(organizationPage);
	}
	public void IndustryType(String industryname,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(industryname);
	}
	
	
	}
	
		
	
		
	
