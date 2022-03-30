package com.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement campaignName;
	
	public WebElement getCampaignName() {
		return campaignName;
	}
	public String readCampaignName() {
		String name=campaignName.getText();
		return name;
	
		}

}
