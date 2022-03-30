package com.vtiger.Genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.Files;

     /**
     * its contains WebDriverspecific reusable actions
	 * 
	 * @return
	 */
 

public class WebDriverUtility {
	
	private static final WebElement WebElement = null;
	/**
	 * wait for page to load before identifying and synchronized element in DOM [HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	/**
	 * wait for page to load before identifying and assynchronized[java scripts actions] element in DOM [HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element to be clickable in GUI & check for specific element for every 500 mili seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable (WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to be clickable in GUI & check for specific element for every 500 mili seconds
	 * @param driver
	 * @param element
	 * @param pollingTime in the form second
	 * @throws Throwable
	 */
	public void waitForElementWithCumstomTimeOut(WebDriver driver,WebElement element,int pollingTime)throws Throwable{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String>set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			       String wID=it.next();
			       driver.switchTo().window(wID);
			       String currentWindowTitle=driver.getTitle();
			       if(currentWindowTitle.contains(partialWindowTitle)) {
			    	   break;
			       }
			     }
	
		}
	/**
	 * used to Switch to Alert Window & click an OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 *used to Switch to Alert Window & click an Cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to Select the value from the dropDown based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to Select the value from the dropDown based on value / options available in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
    public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
    }

    /**
	 * used to right click on specified element 
	 * @param driver
	 * @param element
	 */
    public void rightClickOnElement(WebDriver driver,WebElement element) {
    	Actions act=new Actions( driver);
    	act.contextClick(element).perform();
    }
    /**
   	 * @param driver
   	 * @param javaScript
   	 */
    public void executeJavaScript(WebDriver driver,String javaScript) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeAsyncScript(javaScript, null);
    }
     
	/**
	 * Method is used to take screenshot in the case of failure
	 * @param
	 * @param screenshotName
	 * @return
	 * @throws Throwable
	 */
    public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
    	JavaUtility jUti=new JavaUtility();
    	String filePath="./errorshot/"+screenshotName+jUti.getSystemDateAndTime()+".png";
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File destination=new File(filePath);
    	FileUtils.copyFile(source, destination);
    	return destination.getAbsolutePath();
    }
    
    /**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   }
		
	}
	

	
		
	
 
	
	
	
	
	
	
	
	