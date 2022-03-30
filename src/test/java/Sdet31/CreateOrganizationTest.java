package Sdet31;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.Genericutility.BaseClass;
import com.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.OrganizationInformationPage;
import com.vtiger.ObjectRepositary.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	@Test
	   public void CreateOrganizationTest() throws Throwable {
		
		int randomNum=jUti.getRanDomNumber();
		String ExpectedorgName = eUti.getDataFromExcel("Sheet1",4,0)+randomNum;
				
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganization();
				
		OrganizationPage organizationPage=new OrganizationPage(driver);
		organizationPage.getclickOnAddIcon().click();
				
		CreateNewOrganizationPage createorg=new CreateNewOrganizationPage(driver);
		createorg.fillOrganizationName(ExpectedorgName);
		createorg.getSaveOrganization().click();
				
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.readOrganizationText();
				
				
		/*if(actualOrgName.contains(ExpectedorgName)) {
		System.out.println("organization is created successfully");
		}else {
		System.out.println("organization is failed to create");*/
	SoftAssert softass=new SoftAssert();
	softass.assertEquals(ExpectedorgName, true);
		  }
	   }
	




	


