package com.vtiger.sdet31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.Genericutility.ExcelUtility;
import com.vtiger.Genericutility.FileUtility;
import com.vtiger.Genericutility.JavaUtility;
import com.vtiger.Genericutility.WebDriverUtility;
import com.vtiger.ObjectRepositary.CampaignInformationPage;
import com.vtiger.ObjectRepositary.CampaignPage;
import com.vtiger.ObjectRepositary.CreateNewCampaignPage;
import com.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositary.CreateNewProductPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.LoginPage;
import com.vtiger.ObjectRepositary.OrganizationPage;
import com.vtiger.ObjectRepositary.ProductInformationPage;
import com.vtiger.ObjectRepositary.ProductPage;
import com.vtiger.ObjectRepositary.ProductPopupPage;

public class CreateCampaignWithProuctTest {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;
		/* object creation or utilities */
		JavaUtility jUti = new JavaUtility();
		WebDriverUtility wUti = new WebDriverUtility();
		ExcelUtility eUti = new ExcelUtility();
		FileUtility fUti = new FileUtility();

		/* getting data from property file */
		String browser = fUti.getPropertyKeyValue("browser");
		String url = fUti.getPropertyKeyValue("url");
		String username = fUti.getPropertyKeyValue("username");
		String password = fUti.getPropertyKeyValue("password");

		/* getting the data from excel sheet */
		int randomNum = jUti.getRanDomNumber();
		String productName = eUti.getDataFromExcel("Sheet1", 3, 1) + randomNum;
		String campaignName = eUti.getDataFromExcel("Sheet1", 5, 3) + randomNum;

		/* launching the browser */
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();

		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		wUti.waitForPageToLoad(driver);
		driver.get(url);
		/* login the application */
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);

		
		  HomePage homePage=new HomePage(driver); homePage.clickonProucts(); 
		 ProductPage prodpage=new ProductPage(driver);
		  prodpage.clickOnCreateProduct();
		  
		   CreateNewProductPage createproduct=new  CreateNewProductPage(driver);
		  createproduct.fillProductName(productName);
		  createproduct.savefillInformation();
		  
		  ProductInformationPage productinfopage=new ProductInformationPage(driver);
		  String actualOrgName=productinfopage.ProductName();
		 
		 
		   if(actualOrgName.contains(productName)) {
		  System.out.println("validation pass for product: "+productName); 
		  }else {
		  System.out.println("validation fail for product: "+productName); 
		  }
		  
		  HomePage homepage=new HomePage(driver);
		homepage.moreOver(driver); 
		homepage.getCampaignsLink();
		CampaignPage camPage = new CampaignPage(driver);
		camPage.createCampaign();
		/* navigate to campaign */
		CreateNewCampaignPage createcamp = new CreateNewCampaignPage(driver);
		createcamp.fillCampaignName(campaignName);
		createcamp.getClickOnProductIcon().click();
		String mainId = driver.getWindowHandle();
		wUti.switchToWindow(driver, "Products");
		ProductPopupPage prodpopup = new ProductPopupPage(driver);
		prodpopup.getSearchTextField().sendKeys(productName);
		prodpopup.getSearchForProduct().click();
		prodpopup.selectProductList(driver, productName);
		driver.switchTo().window(mainId);
		createcamp.saveForm();
		/* verification */
		CampaignInformationPage campInfo = new CampaignInformationPage(driver);
		 
		String campSaveInfo = campInfo.readCampaignName();
		System.out.println(campSaveInfo);
		  System.out.println(campaignName);
		  
		if(campSaveInfo.contains(campaignName)){
			System.out.println("validation Pass for Campaign: " + campaignName);
		} 
		else{
			System.out.println("validation Fail for Campaign: " + campaignName);
		}
		/* logout from application */
		homepage.logout(driver);
		driver.quit();
	}

}
