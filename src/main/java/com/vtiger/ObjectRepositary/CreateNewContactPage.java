package com.vtiger.ObjectRepositary;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Element repositary for creatingContactPage
 * @author saraswata
 */

public class CreateNewContactPage {
	
	
     public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
     	@FindBy(xpath="//img[@title='Create Contact...']")
     	private WebElement CreateNewContact;
    
		@FindBy(name="lastname")
     	private WebElement lastname;
		
		@FindBy(xpath="//input[@name='reference']")
		private WebElement checkBox;
		
		@FindBy(xpath="//input[@name='notify_owner']")
		private WebElement notifyCheckBox;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement SaveButton;
	
		@FindBy(xpath="//img[@title='Select']")
		private WebElement organizationAddButton;
		
	//All elements getter method listedbelow */
		public WebElement getCreateNewContact() {
			return CreateNewContact;
		}
		
		public WebElement getSaveButton() {
		return SaveButton;
	}
		public WebElement getNotifyCheckBox() {
			return notifyCheckBox;
		}
	public WebElement getOrganizationAddButton() {
		return organizationAddButton;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getCheckBox() {
		return checkBox;
	}
	/**
	 * This method will fill the last name of the user in the form
	 *@param driver
	 *@pram fullName
	 */
	public void sendLastNameTextField(String FullName) {
		lastname.sendKeys(FullName);
	}
	/**
	 * This method will click on the save the information fill in the form
	 * @param driver
	 */
    public void saveForm(WebDriver driver) {
    	SaveButton.click();
    }
    public void clickOnorganizationAddButton() {
    	organizationAddButton.click();
    	
    }

	public void fillLastName(WebDriver driver, String contactName) {
		lastname.click();
		
	}
	public void clickOnContactIcon(WebDriver driver) {
		CreateNewContact.click();
	}

	
		
	}

	
		
	
    
//driver.findElement(By.xpath("//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")).click();

