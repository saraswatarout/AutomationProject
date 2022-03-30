package Practice;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PickOrganizationNameTest {
	public static void main(String[] args) {
		
		int count=1;
		Random ran=new Random();
		String input="tcs7522"+ran.nextInt(1000);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http:localhost:8888");
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
        driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.cssSelector("input[name='accountname']")).sendKeys(input);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		Navigation nav=driver.navigate();
		nav.refresh();

		driver.findElement(By.linkText("Organizations")).click();
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,3000);");

		String pageCount=driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();
		pageCount=pageCount.substring(3);
		
        int pageCounts=Integer.parseInt(pageCount);
		

		for(int i=1;i<=pageCounts;i++) {
		List<WebElement> allList=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
			for(WebElement wb:allList) {
			String text=wb.getText();
			System.out.println(count+" -"+text);
			count++;
			
			if(text.contains(input)){
				wb.click();
				driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
				driver.switchTo().alert().accept(); 
				}	
			
			try {
			WebElement nextPage=driver.findElement(By.xpath("//a[@title='Next']/img"));
			nextPage.click();
			Thread.sleep(2000);
			}
			catch(Exception e) {
			System.out.println("Page Number- "+pageCounts);
			}	
		}	
		
		WebElement logout=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
}
