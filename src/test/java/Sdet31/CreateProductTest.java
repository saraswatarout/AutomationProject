package Sdet31;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.Genericutility.BaseClass;
import com.vtiger.ObjectRepositary.CreateNewProductPage;
import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.ProductInformationPage;
import com.vtiger.ObjectRepositary.ProductPage;

public class CreateProductTest extends BaseClass {
	@Test
	  public void CreateProductTest() throws Throwable {
		
	int randomNum=jUti.getRanDomNumber();
	String productName = eUti.getDataFromExcel("Sheet1",1,1)+randomNum;
					
					
	HomePage homePage=new HomePage(driver);
	homePage.clickonProucts();
					
	ProductPage prodpage=new ProductPage(driver);
	prodpage.clickOnCreateProduct();
					
	CreateNewProductPage createproduct=new CreateNewProductPage(driver);
	createproduct.fillProductName(productName);
	createproduct.savefillInformation();
					
	ProductInformationPage productinfopage=new ProductInformationPage(driver);
	String actproductName=productinfopage.ProductName();
					
					
	//if(actualOrgName.contains(productName)) {
	//System.out.println("validation pass for product: "+productName);
	//}else {
	//System.out.println("validation fail for product: "+productName);
	Assert.assertEquals(actproductName.contains(productName), true);
	     }
	  }
	
   

