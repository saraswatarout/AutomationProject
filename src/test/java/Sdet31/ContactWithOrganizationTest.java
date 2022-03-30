package Sdet31;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.Genericutility.BaseClass;
import com.vtiger.ObjectRepositary.ContactInformationPage;
import com.vtiger.ObjectRepositary.ContactPage;
import com.vtiger.ObjectRepositary.CreateNewContactPage;
import com.vtiger.ObjectRepositary.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.OrganizationInformationPage;
import com.vtiger.ObjectRepositary.OrganizationPage;
@Listeners(com.vtiger.Genericutility.ListenerImplementationClass.class)
public class ContactWithOrganizationTest extends BaseClass {
	@Test(groups= {"smoke","regression "})
	  public void ContactWithOrganizationTest() throws Throwable {
		
		int randomNum=jUti.getRanDomNumber();
		String ExpectedorgName = eUti.getDataFromExcel("Sheet1",4,0)+randomNum;
		String contactName=eUti.getDataFromExcel("Sheet1",2,2)+randomNum;
			 
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganization();
				
		OrganizationPage organizationPage=new OrganizationPage(driver);
		organizationPage.getclickOnAddIcon().click();
				
		CreateNewOrganizationPage createorg=new CreateNewOrganizationPage(driver);
		createorg.fillOrganizationName(ExpectedorgName);
		createorg.getSaveOrganization().click();
				
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.readOrganizationText();
				
		if(actualOrgName.contains(ExpectedorgName)) {
		System.out.println("organization is created successfully");
		}else {
		System.out.println("organization is failed to create");
		//Assert.assertEquals(actualOrgName,ExpectedorgName);
		} 
				
		homePage.clickOnContact(driver);
				
		ContactPage contactPage=new ContactPage(driver);
		contactPage.CreateNewContact(driver);
				
		CreateNewContactPage createcont=new CreateNewContactPage(driver);
		createcont.sendLastNameTextField(contactName);
		createcont.saveForm(driver);
				
		ContactInformationPage contInfoPage=new ContactInformationPage(driver);
		String actualContactName=contInfoPage.readContactName();
				
				
		if(actualContactName.contains(contactName)) {
		System.out.println("validation pass for contact: "+contactName);
		}else {
		System.out.println("validation fail for contact: "+contactName);
		
		//Assert.assertEquals(actualContactName, contactName);
			}
		
     }
}

	



	

