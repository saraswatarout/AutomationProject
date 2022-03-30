package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
  
  /**
   * Element  repositary for contactspage
   * @author saraswata
   *
   */

public class ContactPage {
	
	public ContactPage(WebDriver driver) {
			PageFactory.initElements( driver,this);
			
		} 
	/*all web elements are listed below*/
	
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement clickOnAddIcon;
		
		
		@FindBy(linkText = "Contacts")
		private WebElement clickOnContact;


		public WebElement getClickOnAddIcon() {
			return clickOnAddIcon;
		}


		public WebElement getClickOnContact() {
			return clickOnContact;
		}


		public void CreateNewContact(WebDriver driver) {
			clickOnContact.click();
			clickOnAddIcon.click();
			
		}
    }
		
		
	


