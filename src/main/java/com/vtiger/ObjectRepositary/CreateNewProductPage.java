package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
   
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTextField;
	
	@FindBy (xpath="//img[@title='Create Product...']")
	private WebElement clickOnProductIcon;
	
	public WebElement getClickOnProductIcon() {
		return clickOnProductIcon;
	}
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveProductInfo;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveProductInfo() {
		return saveProductInfo;
	}
	/**
	 * This method fill the product name to the repective field
	 * @param productname
	 */
	public void fillProductName(String productName) {
		clickOnProductIcon.click();
		productNameTextField.sendKeys(productName);
	}
	/**
	 * This method can save the information which are filled  by the user to the user
	 */
	public void savefillInformation() {
		saveProductInfo.click();
	}
}
