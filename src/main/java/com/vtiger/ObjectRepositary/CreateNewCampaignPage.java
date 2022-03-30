package com.vtiger.ObjectRepositary;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * create camopaign page element repositary
 * @author saraswata
 *
 */

public class CreateNewCampaignPage {
	
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		@FindBy(name="campaignname")
		private WebElement campaignNameTextField;
		
		@FindBy(xpath="//img[@title='Select']")
		private WebElement clickOnProductIcon;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;

		public WebElement getCampaignNameTextField() {
			return campaignNameTextField;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		public WebElement getClickOnProductIcon() {
			return clickOnProductIcon;
		}
		
		public void fillCampaignName(String campaignName) {
		     campaignNameTextField.sendKeys(campaignName);
		}
       public void saveForm() {
    	   saveButton.click();
       }

	  
	}
