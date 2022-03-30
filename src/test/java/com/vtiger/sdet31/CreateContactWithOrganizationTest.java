package com.vtiger.sdet31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.Genericutility.ExcelUtility;
import com.vtiger.Genericutility.FileUtility;
import com.vtiger.Genericutility.JavaUtility;
import com.vtiger.Genericutility.WebDriverUtility;
import com.vtiger.ObjectRepositary.ContactInformationPage;
import com.vtiger.ObjectRepositary.ContactPage;
import com.vtiger.ObjectRepositary.CreateNewContactPage;
import com.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.LoginPage;
import com.vtiger.ObjectRepositary.OrganizationInformationPage;
import com.vtiger.ObjectRepositary.OrganizationPage;

public class CreateContactWithOrganizationTest {
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver =null;
		/*object creation or utilities */
		JavaUtility jUti=new JavaUtility();
		WebDriverUtility wUti=new WebDriverUtility();
		ExcelUtility eUti=new ExcelUtility();
		FileUtility fUti=new FileUtility();
		
		int randomNum=jUti.getRanDomNumber();
		/* getting data from property file */
		String browser =fUti.getPropertyKeyValue("browser");
		String url = fUti.getPropertyKeyValue("url");
		String username =fUti.getPropertyKeyValue("username");
		String password=fUti.getPropertyKeyValue("password");
		
		/*getting the data from excel sheet */
		String ExpectedorgName = eUti.getDataFromExcel("Sheet1",4,0)+randomNum;
		String contactName=eUti.getDataFromExcel("Sheet1",2,2)+randomNum;
	 /*launching the browser */
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
		/* login  the application */	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		/* navigate to organization */
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganization();
		/* navigate to create organization */
		OrganizationPage organizationPage=new OrganizationPage(driver);
		organizationPage.getclickOnAddIcon().click();
		
		/* create a new organization */
		CreateNewOrganizationPage createorg=new CreateNewOrganizationPage(driver);
		createorg.fillOrganizationName(ExpectedorgName);
		createorg.getSaveOrganization().click();
		
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.readOrganizationText();
		
		//verification
		if(actualOrgName.contains(ExpectedorgName)) {
			System.out.println("organization is created successfully");
		}else {
			System.out.println("organization is failed to create");
		}   
		
		homePage.clickOnContact(driver);
		/* navigate to create contact */
		ContactPage contactPage=new ContactPage(driver);
		contactPage.CreateNewContact(driver);
		
		/* create new contact */
		CreateNewContactPage createcont=new CreateNewContactPage(driver);
		createcont.sendLastNameTextField(contactName);
		createcont.saveForm(driver);
		
		ContactInformationPage contInfoPage=new ContactInformationPage(driver);
		String actualContactName=contInfoPage.readContactName();
		
		/* verification */
		if(actualContactName.contains(contactName)) {
			System.out.println("validation pass for contact: "+contactName);
		}else {
			System.out.println("validation fail for contact: "+contactName);
		}
		/* logout from application */
		
		homePage.logout(driver);
		driver.quit();
			
	}
}


