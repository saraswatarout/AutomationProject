  package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTest {
    public static void main(String[] args) {
		
	String monthAndYear="May 2022";
		String date="8";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("");
		
		
		
		Actions act=new Actions(driver);
		act.moveByOffset(10,10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
   driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
   
   String path="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descedant::p[text()='"+date+"']";
   	for(;;)	{
   		try {
   driver.findElement(By.xpath(path)).click();
   break;
   	}  catch (Exception e) {
   		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		
	    }
   	}
	}
}

