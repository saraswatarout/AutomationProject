package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.Genericutility.WebDriverUtility;

public class HomePage {
	WebDriverUtility wUti=null;
	//initialization of web elements
			public HomePage(WebDriver driver) {
				PageFactory.initElements(driver,this);
			}
	//declaration of web element
			@FindBy(xpath="//a[text()='More']")
			private WebElement MoreLink;
			
			@FindBy(linkText="Organizations")
			private WebElement OrganizationLink;
			
			@FindBy(linkText="Leads")
			private WebElement LeadsLink;
			
			@FindBy(linkText="Contacts")
			private WebElement ContactsLink;
			
			@FindBy(linkText="Products")
			private WebElement ProductsLink;
			
			@FindBy(linkText="Campaigns")
			private WebElement CampaignsLink;
			
			@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
			private WebElement signOutIconImage;
			
			@FindBy(linkText="Sign Out")
			private WebElement SignOutLink;
			
			//getter method to use in it the test script

			public WebElement getOrganizationsLink() {
				return OrganizationLink;
			}

			public WebElement getMoreLink() {
				return MoreLink;
			}

			public WebElement getOrganizationLink() {
				return OrganizationLink;
			}

			public WebElement getLeadsLink() {
				return LeadsLink;
			}

			public WebElement getContactsLink() {
				return ContactsLink;
			}

			public WebElement getProductsLink() {
				return ProductsLink;
			}

			public WebElement getCampaignsLink() {
				return CampaignsLink;
			}

			public WebElement getSignOutIconImage() {
				return signOutIconImage;
			}

			public WebElement getSignOutLink() {
				return SignOutLink;
			}
		//business logic
			/**
			 * This method will click organization  link
			 * @param driver
			 */
			public void clickOnOrganization() {
				OrganizationLink.click();
			}
			/**
			 * this method will logout the application
			 * @param driver
			 */
			public void logout(WebDriver driver) {
				wUti=new WebDriverUtility();
				wUti.mouseOverOnElement(driver,signOutIconImage);
				SignOutLink.click();
			}
			/**
			 * This method clicks on the contact link
			 * @param driver
			 */
			public void clickOnContact(WebDriver driver) {
				ContactsLink.click();
			}
			public void clickonProucts() {
				ProductsLink.click();
			}
			public void moreOver(WebDriver driver) {
				wUti=new WebDriverUtility();
				WebElement more = MoreLink;
				wUti.waitForElementToBeClickable(driver, more);
				wUti.mouseOverOnElement(driver, more);
				CampaignsLink.click();
				
			}
			
		 }
			