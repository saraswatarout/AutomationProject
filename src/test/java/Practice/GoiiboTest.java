package Practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoiiboTest {
	public static void main(String[] args) {
		 	
		int count=1;
		LocalDateTime localTime=LocalDateTime.now().plusDays(10);
		int year=localTime.getYear();
		int checkInDate=localTime.getDayOfMonth();
		String checkInMonth=localTime.getMonth().toString();
		checkInMonth=checkInMonth.substring(0,1)+checkInMonth.substring(1).toLowerCase();
		String checkInMonthYear=checkInMonth+" "+year;
		System.out.println(checkInMonthYear);
		
		
	/* Cheak-Out Date Formate*/	
		LocalDateTime localtimes=LocalDateTime.now().plusDays(15);
		int checkOutDate=localtimes.getDayOfMonth();
		String CheckOutMonth=localtimes.getMonth().toString();
		CheckOutMonth=CheckOutMonth.substring(0,1)+CheckOutMonth.substring(1).toLowerCase();
		String	CheckOutMonthYear=CheckOutMonth+" "+year;
		System.out.println(CheckOutMonthYear);
			
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
    
	/* For Choose Hotel Module and Indian Hotels CheckBox */
		driver.findElement(By.xpath("//ul[@class='happy-nav']/li/following-sibling::li/a[text()='Hotels']")).click();
		driver.findElement(By.xpath("//h4[text()='India']")).click();

	/* Clicking Cheack-In Date */
		driver.findElement(By.xpath("//div[text()='Check-in']")).click();
		driver.findElement(By.xpath("//span[@class='dcalendar-newstyles__MonthName-sc-1i003by-12 jdlFBV' and text()='"+checkInMonthYear+"']/../following-sibling::div/div/ul/following-sibling::ul/li/span[text()='"+checkInDate+"']")).click();
		driver.findElement(By.xpath("//span[@class='dcalendar-newstyles__MonthName-sc-1i003by-12 jdlFBV' and text()='"+CheckOutMonthYear+"']/../following-sibling::div/div/ul/following-sibling::ul/li/span[text()='"+checkOutDate+"']")).click();
		driver.findElement(By.xpath("//input[@class='SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH']")).click();
		/* Choose How Much Room Want  */
			driver.findElement(By.xpath("//span[text()='Rooms']/following-sibling::div/h4[text()='1']/following-sibling::span")).click();
		/* Choose Adults Of Staying */
			driver.findElement(By.xpath("//span[text()='Adults']/following-sibling::div/span[2]")).click();
		/* Children Count */
			driver.findElement(By.xpath("//span[text()='Children']/following-sibling::div/span[2]")).click();
			driver.findElement(By.xpath("//span[text()='Children']/following-sibling::div/span[2]")).click();
			driver.findElement(By.xpath("//span[text()='Children']/following-sibling::div/span[2]")).click();
			driver.findElement(By.xpath("//span[text()='Child ' and text()='1']/following-sibling::div")).click();
		/* Selecting Children Age */
			WebElement child1=driver.findElement(By.xpath("//span[text()='Child ' and text()='1']/following-sibling::ul/li[text()='5']"));
			child1.click();
			driver.findElement(By.xpath("//span[text()='Child ' and text()='2']/following-sibling::div")).click();
			WebElement child2=driver.findElement(By.xpath("//span[text()='Child ' and text()='2']/following-sibling::ul/li[text()='8']"));
			child2.click();
			driver.findElement(By.xpath("//span[text()='Child ' and text()='3']/following-sibling::div")).click();
			WebElement child3=driver.findElement(By.xpath("//span[text()='Child ' and text()='3']/following-sibling::ul/li[text()='10']"));
			child3.click();
		/* Done Button */
			driver.findElement(By.xpath("//button[text()='Done']")).click();
		//driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
			
				driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")).click();
				driver.findElement(By.xpath("//p[text()='Mumbai']")).click();
			
			/* Collecting All Hotels Name Which is Available on that location */
				List<WebElement> hotelList=driver.findElements(By.xpath("//div[@class='infinite-scroll-component ']/div/div/div/div/following-sibling::div/div/div/div/following-sibling::div/h4"));
			
			
			for(int i=1;i<=10;i++) {			
				
				/* For Scrolling Down To Load More Hotels Name */ 
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,5000);");
				/* For Getting Hotel Name In Text */ 
				for(WebElement wb:hotelList) {
					String hotelName=wb.getText();
					System.out.println(count+"- "+hotelName);
					count++;			
				}

			}
		}

	}

