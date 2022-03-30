package com.crm.autodesk.createOrganization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.Genericutility.ExcelUtility;
import com.vtiger.Genericutility.FileUtility;
import com.vtiger.Genericutility.JavaUtility;
import com.vtiger.Genericutility.WebDriverUtility;

public class CreateContactWithOrganizationTest {
	public static void main(String[] args) throws Throwable {
		
		JavaUtility jUti=new JavaUtility();
		WebDriverUtility wUti=new WebDriverUtility();
		ExcelUtility eUti=new ExcelUtility();
		FileUtility fUti=new FileUtility();
		
		int randomNum=jUti.getRanDomNumber();
		
				
				String browser =fUti.getPropertyKeyValue("browser");
				String url = fUti.getPropertyKeyValue("url");
				String username =fUti.getPropertyKeyValue("username");
				String password=fUti.getPropertyKeyValue("password");
				
				
			
				String contactName= eUti.getDataFromExcel("Sheet1",5,2)+randomNum;
				System.out.println("contact name"+contactName);
				String orgName = eUti.getDataFromExcel("Sheet1",5,0)+randomNum;
				System.out.println("organization name"+orgName);
				
				
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
			
			//step:2 navigate to organization;
			driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
			
			//step:3 navigate to create organization page
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//create a new org
			 driver.findElement(By.name("accountname")).sendKeys(orgName);
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			 
			 WebElement actHeaderMsg =driver.findElement(By.className("dvHeaderText"));
			 
				wUti.waitForElementToBeClickable(driver, actHeaderMsg);
				
			//step:5 navigate to organization
			driver.findElement(By.linkText("Contacts")).click();
			
			//step:6 navigate to create contact page
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			//create a new contact
			driver.findElement(By.name("lastname")).sendKeys(contactName);
			 driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			 
			 wUti.switchToWindow(driver, "Accounts");
			 
			
			 driver.findElement(By.id("search_txt")).sendKeys(orgName);
			 driver.findElement(By.name("search")).click();
			 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			 wUti.switchToWindow(driver, "Contacts");
          
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
				//step:6 logout
				wUti.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
				driver.findElement(By.linkText("Sign Out")).click();
			    driver.close();
	}

}
