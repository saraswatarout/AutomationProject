package com.vtiger.sdet31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.Genericutility.ExcelUtility;
import com.vtiger.Genericutility.FileUtility;
import com.vtiger.Genericutility.JavaUtility;
import com.vtiger.Genericutility.WebDriverUtility;
import com.vtiger.ObjectRepositary.CreateNewContactPage;
import com.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.LoginPage;
import com.vtiger.ObjectRepositary.OrganizationInformationPage;
import com.vtiger.ObjectRepositary.OrganizationPage;

public class CreateOrganizationTest {
	public static void main(String[] args) throws Throwable {
		
	
		WebDriver driver =null;
		/* object creation or utilities */
		JavaUtility jUti=new JavaUtility();
		WebDriverUtility wUti=new WebDriverUtility();
		ExcelUtility eUti=new ExcelUtility();
		FileUtility fUti=new FileUtility();
		/* getting data from property file */
		String browser =fUti.getPropertyKeyValue("browser");
		String url = fUti.getPropertyKeyValue("url");
		String username =fUti.getPropertyKeyValue("username");
		String password=fUti.getPropertyKeyValue("password");
		
		/* getting the data from excel sheet */
		int randomNum=jUti.getRanDomNumber();
		String ExpectedorgName = eUti.getDataFromExcel("Sheet1",4,0)+randomNum;
		
	 /* launching the browser */
				if(browser.equals("chrome")) {
					driver =new ChromeDriver();
					
				}else if (browser.equals("firefox")) {
					driver=new FirefoxDriver();
			
				}else {
					driver=new ChromeDriver();
				}
				
			driver.manage().window().maximize();
			wUti.waitForPageToLoad(driver);
			driver.get(url);
		/* login the application */	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		/* go to homepage */
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganization();
		/* navigate to organization page */
		OrganizationPage organizationPage=new OrganizationPage(driver);
		organizationPage.getclickOnAddIcon().click();
		
		/* navigate to create organization page */
		CreateNewOrganizationPage createorg=new CreateNewOrganizationPage(driver);
		createorg.fillOrganizationName(ExpectedorgName);
		createorg.getSaveOrganization().click();
		
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.readOrganizationText();
		
		/* verification */
		if(actualOrgName.contains(ExpectedorgName)) {
			System.out.println("organization is created successfully");
		}else {
			System.out.println("organization is failed to create");
		}
		/* logout from application */
		homePage.logout(driver);
		driver.quit();
		
			}
	}



