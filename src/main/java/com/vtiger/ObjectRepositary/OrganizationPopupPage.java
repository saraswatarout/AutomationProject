package com.vtiger.ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
   * Element repositary for organizationPopup page
   * @author saraswata
   *
   */
public class OrganizationPopupPage {
	
	public OrganizationPopupPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		}
	/* all web element listed below */
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement organizationSearchField;
	
	@FindBy (xpath="//input[@name='search']")
	private WebElement searchButton;
	/* all getters methods listed below */
	public WebElement getOrganizationSearchField() {
		return organizationSearchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public void searchOrganization(String organizationName) {
		organizationSearchField.sendKeys(organizationName);
		searchButton.click();
	}
	public void selectOrganization(WebDriver driver,String organizationName) {
		driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
	}
	

}
