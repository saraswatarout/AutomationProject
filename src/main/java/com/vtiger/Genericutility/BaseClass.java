package com.vtiger.Genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.ObjectRepositary.HomePage;
import com.vtiger.ObjectRepositary.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
     public  WebDriver driver=null;
     public WebDriverUtility wUti=new WebDriverUtility();
     public FileUtility fUti=new FileUtility();
     public ExcelUtility eUti=new ExcelUtility();
     public JavaUtility jUti=new JavaUtility();
     public static WebDriver sDriver;
     
     @BeforeSuite(groups= {"smoke","sanity","integration","regression"})
     public void beforeSuite() {
    	 System.out.println("data base connection");
     }
     @BeforeTest(groups= {"smoke","sanity","integration","regression"})
     public void beforeTest() {
    	 System.out.println("execute script in parallel mode");
     }
   // @Parameters("browsername")
     @BeforeClass(groups= {"smoke","sanity","integration","regression"})
     public void beforeClass() throws Throwable {
    	 FileUtility fUti=new FileUtility();
    	 String browserName=fUti.getPropertyKeyValue("browser");
    	 String url=fUti.getPropertyKeyValue("url");
    	 if(browserName.equals("chrome")) {
    		  WebDriverManager.chromedriver().setup();
    		  driver=new ChromeDriver();
    	 }else if(browserName.equals("firefox")) {
    		  WebDriverManager.chromedriver().setup();
    		  driver=new FirefoxDriver();
    	}else {
    		throw new Exception("browser is not compatible");
    	}
    	 driver.get(url);
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	 sDriver=driver;
        }
        @BeforeMethod(groups= {"smoke","sanity","integration","regression"})
        public void beforeMethod() throws Throwable {
    	 String userName=fUti.getPropertyKeyValue("username");
    	 String password=fUti.getPropertyKeyValue("password");
    	 LoginPage loginpage=new LoginPage(driver);
    	 loginpage.login(userName, password);
         }
     
          @AfterMethod(groups= {"smoke","sanity","integration","regression"})
         public void afterMethod() {
    	  HomePage homepage=new HomePage(driver);
    		homepage.logout(driver);
         }
         @AfterClass(groups= {"smoke","sanity","integration","regression"})
         public void afterClass() {
    	    driver.quit();
         }
         @AfterTest(groups= {"smoke","sanity","integration","regression"})
         public void afterTest() {
    	   System.out.println("close parallel mode execution");
        }
         @AfterSuite(groups= {"smoke","sanity","integration","regression"})
          public void afterSuite() {
        	 System.out.println("close the data connection");
        }
     
    }
