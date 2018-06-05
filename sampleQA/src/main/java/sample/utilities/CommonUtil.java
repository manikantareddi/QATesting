package sample.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class CommonUtil {

	public static String imageFolder = "\\Screenshot\\";
	
	public static void captureScreenshot(WebDriver driver,String moduleName, String screenshotName)
	{
	  try 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			String PATH_TO_PACKAGE = System.getProperty("user.dir");			
			String filepath = PATH_TO_PACKAGE + imageFolder + moduleName + "\\" + screenshotName+".png";
			
			File f = new File(filepath);
			if(f.exists()) { 
				
				System.out.println(filepath);
				System.out.println("Screenshot already exist :" + screenshotName );
					
			}
			
			FileUtils.copyFile(source, new File(filepath));
			
			
			System.out.println("Screenshot taken :" + screenshotName );
		} 
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
	}
	
	public static WebElement fluentWait(WebDriver driver, final By locator) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);
	            
	    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    });

	    return  element;
	};
	

	public static boolean isElementPresent(WebDriver driver,By by) {
	    try {
	      driver.findElements(by);
	      return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	      return false;
	    }
	}

	public static void toasterMessages(WebDriver driver,String moduleName, String msg_in_alert,boolean positive){
		if (positive)
			Assert.assertTrue(!msg_in_alert.contains(msg_in_alert.substring(2, msg_in_alert.lastIndexOf("Message") + 7)),
					msg_in_alert.substring(msg_in_alert.lastIndexOf("Message") + 8));
		else
			Assert.assertTrue(msg_in_alert.contains(msg_in_alert.substring(2, msg_in_alert.lastIndexOf("Message") + 7)),
					msg_in_alert.substring(msg_in_alert.lastIndexOf("Message") + 8));
		captureScreenshot(driver,moduleName,"ToastMessage1");
	}

	public static String DatetoString() {
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String datetoString = sdf.format(currentDate);
		return datetoString;

	}
	
	public static WebElement highlightElement(WebDriver driver,WebElement elem) {
	   
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid orange'", elem);
	    }
	    return elem;
	}
	
	public static WebElement ClearElementBorder(WebDriver driver,WebElement elem) {
		   
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='none'", elem);
	    }
	    return elem;
	}
}

