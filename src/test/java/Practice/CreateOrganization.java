package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.Genericutility.ExcelUtility;
import com.vtiger.Genericutility.FileUtility;
import com.vtiger.Genericutility.JavaUtility;
import com.vtiger.Genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {
		JavaUtility jUti=new JavaUtility();
		WebDriverUtility wUti=new WebDriverUtility();
		ExcelUtility eUti=new ExcelUtility();
		FileUtility fUti=new FileUtility();
		
		int randomNum=jUti.getRanDomNumber();
		
		String browser =fUti.getPropertyKeyValue("browser");
		String url = fUti.getPropertyKeyValue("url");
		String username =fUti.getPropertyKeyValue("username");
		String password=fUti.getPropertyKeyValue("password");
		
		
		String contactName = eUti.getDataFromExcel("Sheet1",2,2)+randomNum;
		
		WebDriver driver =null;
		if(browser.equals("chrome")) {
			driver =new ChromeDriver();
			
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
	
		}else {
			driver=new ChromeDriver();
		}
		wUti.waitForPageToLoad(driver);
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	   driver.findElement(By.name("accountname")).sendKeys( contactName);
		
		WebElement wb1= driver.findElement(By.xpath("(//select[@class='small'])[2]"));
	    Select s=new Select(wb1);
		s.selectByValue("Healthcare");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement  actHeaderMsg =driver.findElement(By.className("dvHeaderText"));
		wUti.waitForElementToBeClickable(driver, actHeaderMsg);
		
		
		wUti.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
	    driver.close();
		  
			
		}
	}
	


