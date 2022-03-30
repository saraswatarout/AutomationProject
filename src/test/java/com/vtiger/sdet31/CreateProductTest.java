package com.vtiger.sdet31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.Genericutility.ExcelUtility;
import com.vtiger.Genericutility.FileUtility;
import com.vtiger.Genericutility.JavaUtility;
import com.vtiger.Genericutility.WebDriverUtility;
import com.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositary.CreateNewProductPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.LoginPage;
import com.vtiger.ObjectRepositary.OrganizationInformationPage;
import com.vtiger.ObjectRepositary.OrganizationPage;
import com.vtiger.ObjectRepositary.ProductInformationPage;
import com.vtiger.ObjectRepositary.ProductPage;

public class CreateProductTest {
	public static void main(String[] args) throws Throwable {
		
			WebDriver driver =null;
			/*object creation or utilities */
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
			String productName = eUti.getDataFromExcel("Sheet1",1,1)+randomNum;
			
			
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
			/* login the application */	
			LoginPage loginpage=new LoginPage(driver);
			loginpage.login(username, password);
			/* navigate to product module */
			HomePage homePage=new HomePage(driver);
			homePage.clickonProucts();
			/* navigate to  product */
			ProductPage prodpage=new ProductPage(driver);
			prodpage.clickOnCreateProduct();
			
			/* navigate to create product */
			CreateNewProductPage createproduct=new CreateNewProductPage(driver);
			createproduct.fillProductName(productName);
			createproduct.savefillInformation();
			
			ProductInformationPage productinfopage=new ProductInformationPage(driver);
			String actualOrgName=productinfopage.ProductName();
			
			//verification
			if(actualOrgName.contains(productName)) {
				System.out.println("validation pass for product: "+productName);
			}else {
				System.out.println("validation fail for product: "+productName);
			}
			/* logout from application */
			homePage.logout(driver);
			driver.quit();
			
				}
		}





