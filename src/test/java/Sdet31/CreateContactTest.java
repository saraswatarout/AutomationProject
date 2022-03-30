package Sdet31;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.Genericutility.BaseClass;
import com.vtiger.ObjectRepositary.ContactInformationPage;
import com.vtiger.ObjectRepositary.ContactPage;
import com.vtiger.ObjectRepositary.CreateNewContactPage;
import com.vtiger.ObjectRepositary.HomePage;
@Test(retryAnalyzer =com.vtiger.Genericutility.RetryAnalyzerImplementationClass.class )
public class CreateContactTest extends BaseClass {
	@Test(groups= "smoke")
	
	 public void CeateContactTest() throws Throwable {
		
	 int randomNum=jUti.getRanDomNumber();
	  String contactName = eUti.getDataFromExcel("Sheet1",2,2)+randomNum;
						
	   
		HomePage homePage=new HomePage(driver);
		homePage.clickOnContact(driver);
			
		ContactPage contactPage=new ContactPage(driver);
		contactPage.CreateNewContact(driver);
						
		CreateNewContactPage createcont=new CreateNewContactPage(driver);
		createcont.sendLastNameTextField(contactName);
		createcont.saveForm(driver);
						
		ContactInformationPage contInfoPage=new ContactInformationPage(driver);
		String actualContactName=contInfoPage.readContactName();
						
		/*if(actualContactName.contains(contactName)) {
		System.out.println("validation pass for contact: "+contactName);
		}else {
		System.out.println("validation fail for contact: "+contactName)*/;
		Assert.assertEquals( actualContactName.contains(contactName), true);
		}
					
	}
					
 


