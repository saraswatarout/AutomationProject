package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignImage;
	
	public WebElement getCreateCampaignImage() {
		return createCampaignImage;
	}
	
	public void createCampaign() {
		createCampaignImage.click();
	}

}
