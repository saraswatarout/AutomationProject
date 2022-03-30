package com.vtiger.ObjectRepositary;
 /**
  * Element repositary of  productpage
  * @author saraswata
  *
  */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductLink;
	
	
	/* all getters method listed below*/
	public WebElement getCreateProductLink() {
		return createProductLink;
	}
	public void clickOnCreateProduct() {
		createProductLink.click();
	}

}

