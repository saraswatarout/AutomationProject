package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}
	
	/*header web-element  for verification*/
	
	@FindBy(className="dvHeaderText")
	private WebElement OrganizationsName;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryTypeField;
	  
	
	/* getter for external access*/
	
	
	/*business logic*/
	/*All the operations for organizationInfopage listed below */
	
	public WebElement getOrganizationsName() {
		return OrganizationsName;
	}
	public WebElement getIndustryTypeField() {
		return industryTypeField;
	}
	/**
	 * This method will read the organization name created one
	 * @return
	 */

	public String readOrganizationText() {
		String OrgName=OrganizationsName.getText();
		return OrgName;
	}
	public String readIndustryType() {
		String Name=industryTypeField.getText();
		return Name;
	}
	}

