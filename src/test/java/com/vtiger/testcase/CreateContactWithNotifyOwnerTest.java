package com.vtiger.testcase;

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
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.LoginPage;

        public class CreateContactWithNotifyOwnerTest {
	        public static void main(String[] args) throws Throwable {
		
		        WebDriver driver =null;
					/*object creation or utilities */
					JavaUtility jUti=new JavaUtility();
					WebDriverUtility wUti=new WebDriverUtility();
					ExcelUtility eUti=new ExcelUtility();
					FileUtility fUti=new FileUtility();
					
					/* getting data from property file*/
					String browser =fUti.getPropertyKeyValue("browser");
					String url = fUti.getPropertyKeyValue("url");
					String username =fUti.getPropertyKeyValue("username");
					String password=fUti.getPropertyKeyValue("password");
					
					 /*getting the data from excel sheet */
					int randomNum=jUti.getRanDomNumber();
					 String lastName= eUti.getDataFromExcel("Sheet1",4,4)+randomNum; 
					  
					  /*launching the browser */
							if(browser.equals("chrome")) {
								driver =new ChromeDriver();
								
							}else if (browser.equals("firefox")) {
								driver=new FirefoxDriver();
						
							}else {
								driver=new ChromeDriver();
							}
						/*maximise window */
							driver.manage().window().maximize();
						wUti.waitForPageToLoad(driver);
						driver.get(url);
						/*login */
						LoginPage lp=new LoginPage(driver);
						lp.login(username, password);
						/* click on contact */
						HomePage hp=new HomePage(driver);
						hp.clickOnContact(driver);
						/*click on create icon */
						ContactPage cp=new ContactPage(driver);
						cp.getClickOnAddIcon().click();		
						
						CreateNewContactPage cncp=new CreateNewContactPage(driver);
						cncp.sendLastNameTextField(lastName);
						/*click on checkBox */
						cncp.getNotifyCheckBox().click();
						cncp.getSaveButton().click();
						
						/*validation */
						ContactInformationPage continfo=new ContactInformationPage(driver);
						String getText=continfo.readContactName();
						
			              if(getText.contains(lastName)) {
							System.out.println("Validation Pass");
						}else {
							System.out.println(" Validation failed ");
						}
			              
			              /*logout from application */
						hp.logout(driver);
						driver.quit();	
			}

		}

	


