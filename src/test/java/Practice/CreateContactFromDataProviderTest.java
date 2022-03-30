package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactFromDataProviderTest {
	@Test(dataProvider="getdata")
	
	public void contactdata(String lastName,String mobileNo) {
		 System.out.println(lastName);
		 System.out.println(mobileNo);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http:localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.id("mobile")).sendKeys(mobileNo);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}
		@DataProvider
		public Object[][] getdata() {
			Object[][] objarr= new Object[5][2];
			    
			objarr[0][0]="saraswata";
			objarr[0][1]="9078432176";
			
			objarr[1][0]="amit";
			objarr[1][1]="8637266240";
			
			objarr[2][0]="rakesh";
			objarr[2][1]="9548302859";
			
			objarr[3][0]="prakash";
			objarr[3][1]="8907659870";
			
			objarr[4][0]="swarup";
			objarr[4][1]="9765290546";
			 return objarr;
		}
	}


