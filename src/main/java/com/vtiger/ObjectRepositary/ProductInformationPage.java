package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Element Repositry for productinformationpage
 * @author saraswata
 *
 */
public class ProductInformationPage {
	
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(className="lvtHeaderText")
	private WebElement productCreateName;
	
	
	public WebElement getProductCreateName() {
		return productCreateName;
	}
	public String ProductName() {
		String name=productCreateName.getText();
		return name;
	}
	
	}
