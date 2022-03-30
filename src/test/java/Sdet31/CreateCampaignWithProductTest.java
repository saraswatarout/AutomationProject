package Sdet31;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.vtiger.Genericutility.BaseClass;
import com.vtiger.ObjectRepositary.CampaignInformationPage;
import com.vtiger.ObjectRepositary.CampaignPage;
import com.vtiger.ObjectRepositary.CreateNewCampaignPage;
import com.vtiger.ObjectRepositary.CreateNewProductPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.ProductInformationPage;
import com.vtiger.ObjectRepositary.ProductPage;
import com.vtiger.ObjectRepositary.ProductPopupPage;
 
public class CreateCampaignWithProductTest extends BaseClass {
	
	@Test(groups= "regression")
	  
	   public void CreateCampaignWithProductTest() throws Throwable {
			
			int randomNum=jUti.getRanDomNumber();
			String productName = eUti.getDataFromExcel("Sheet1",3,1)+randomNum;
			String campaignName=eUti.getDataFromExcel("Sheet1",5,3)+randomNum;
			
				HomePage homePage=new HomePage(driver);
				homePage.clickonProucts();
			
				ProductPage prodpage=new ProductPage(driver);
				prodpage.clickOnCreateProduct();
				
				CreateNewProductPage createproduct=new CreateNewProductPage(driver);
				createproduct.fillProductName(productName);
				createproduct.savefillInformation();
				
				ProductInformationPage productinfopage=new ProductInformationPage(driver);
				String actualOrgName=productinfopage.ProductName();
				
				
				if(actualOrgName.contains(productName)) {
					System.out.println("validation pass for product: "+productName);
				}else {
					System.out.println("validation fail for product: "+productName);
				}
				
				
				homePage.moreOver(driver);
			
				homePage.getCampaignsLink();
				CampaignPage camPage=new CampaignPage(driver) ;
		        camPage.createCampaign();
		        
		        CreateNewCampaignPage createcamp=new CreateNewCampaignPage(driver);
				createcamp.fillCampaignName(campaignName);
				createcamp.getClickOnProductIcon().click();
				String mainId=driver.getWindowHandle();
			
				wUti.switchToWindow(driver, "Products");
				ProductPopupPage prodpopup=new ProductPopupPage(driver);
				prodpopup.getSearchTextField().sendKeys(productName);
				prodpopup.getSearchForProduct().click();
				prodpopup.selectProductList(driver, productName);
				driver.switchTo().window(mainId);
				createcamp.saveForm();
				
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
			}
	  }



