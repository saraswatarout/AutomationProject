package Practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTodaysdateTest {
	public static void main(String[] args) {
		 
		
		LocalDateTime datetime=LocalDateTime.now();
		String month=datetime.getMonth().toString();
		int date = datetime.getDayOfMonth();
		int year = datetime.getYear();
		String currentMonth=month.substring(0,1)+month.substring(1).toLowerCase();
		String monthAndYear=currentMonth+" "+year;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.makemytrip.com/");
		
		Actions act=new Actions(driver);
		act.moveByOffset(10,10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
		driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
	   driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//p[text()='Delhi, India']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		
		 String path="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descedant::p[text()='"+date+"']";
		   driver.findElement(By.xpath(path)).click();
		   
		  List<WebElement> name=driver.findElements(By.xpath("//span[@class='boldFont airlineName']"));
		  
		  for(WebElement i:name) {
			  System.out.println(i.getText());
		  }
		  driver.close();
	 
        }
   	
	}

      
   
	

	
