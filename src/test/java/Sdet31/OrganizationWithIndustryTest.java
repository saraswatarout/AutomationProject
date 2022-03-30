package Sdet31;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.Genericutility.BaseClass;
import com.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.OrganizationInformationPage;
import com.vtiger.ObjectRepositary.OrganizationPage;

public class OrganizationWithIndustryTest extends BaseClass {
	    @Test
		 public void OrganizationWithIndustyTest() throws Throwable {
		
			    int randomNum=jUti.getRanDomNumber();
				/*getting the data from excel sheet */
				String ExpectedorgName = eUti.getDataFromExcel("Sheet1",4,0)+randomNum;
				String industryName=eUti.getDataFromExcel("Sheet1",1,5);
				
				
				HomePage homePage=new HomePage(driver);
				homePage.clickOnOrganization();
				/* create organization page */
				OrganizationPage organizationPage=new OrganizationPage(driver);
				organizationPage.getclickOnAddIcon().click();
				
				/* create new organization page */
				CreateNewOrganizationPage createorg=new CreateNewOrganizationPage(driver);
				createorg.fillOrganizationName(ExpectedorgName);
				WebElement industryelement=createorg.getIndustryType();
				createorg.IndustryType(industryName,industryelement);
				createorg.getSaveOrganization().click();
				
				
				OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
				String actualOrgName=orgInfoPage.readOrganizationText();
				
				/* verification */
				if(actualOrgName.contains(ExpectedorgName)) {
					System.out.println("organization is created successfully");
				}else {
					System.out.println("organization is failed to create");
				}
				
			   }
			}
			








