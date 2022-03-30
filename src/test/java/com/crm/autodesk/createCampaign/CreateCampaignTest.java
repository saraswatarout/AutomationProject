package com.crm.autodesk.createCampaign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.Genericutility.ExcelUtility;
import com.vtiger.Genericutility.FileUtility;
import com.vtiger.Genericutility.JavaUtility;
import com.vtiger.Genericutility.WebDriverUtility;

public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {

		JavaUtility jUti=new JavaUtility();
		WebDriverUtility wUti=new WebDriverUtility();
		ExcelUtility eUti=new ExcelUtility();
		FileUtility fUti=new FileUtility();
		
		int randomNum=jUti.getRanDomNumber();
		
		//Data driven by using java property file
		
		String browser =fUti.getPropertyKeyValue("browser");
		String url = fUti.getPropertyKeyValue("url");
		String username =fUti.getPropertyKeyValue("username");
		String password=fUti.getPropertyKeyValue("password");
		
		//Data driven by using excel sheet
		
		String campaignName = eUti.getDataFromExcel("Sheet1",4,3)+randomNum;
		String productName=eUti.getDataFromExcel("Sheet1",5,1)+randomNum;
		
		WebDriver driver =null;
		if(browser.equals("chrome")) {
			driver =new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
	         driver=new ChromeDriver();
		}    
	 wUti.waitForPageToLoad(driver);
	 driver.get(url);
		
	 driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
        driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();  
		
		//mouse mover
		
		wUti.mouseOverOnElement(driver, driver.findElement(By.linkText("More")));
		
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		
		//Navigate to create campaign
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		//create a new campaign
		
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String mainId=driver.getWindowHandle();
		wUti.switchToWindow(driver,"Products");
		driver.findElement(By.name("search_text")).sendKeys(productName);
       driver.findElement(By.name("search")).click();
       driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
       driver.switchTo().window(mainId);
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
     
		 WebElement actHeaderMsg=driver.findElement(By.className("dvHeaderText"));
		 
		    wUti.waitForElementToBeClickable(driver,actHeaderMsg);
		   
		wUti.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		 driver.close();
		 
	}

}
