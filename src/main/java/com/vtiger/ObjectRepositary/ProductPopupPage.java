package com.vtiger.ObjectRepositary;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPopupPage {
	
	public ProductPopupPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchForProduct() {
		return searchForProduct;
	}
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchTextField;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchForProduct;
	
	public void selectProductList(WebDriver driver,String product) {
		driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
	}

}
