package sample.sampleQA;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import sample.utilities.CommonUtil;

public class LogIn_Page {
	  private WebDriver driver;
	public void  LogIn_Page(WebDriver driver) {
	        this.driver = driver;
	    }
	String moduleName = "LogIn";

	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement EmailorPhonenumber;
	@FindBy(xpath = "//div[@id='identifierNext']")
	WebElement Emailnextbtn;
	@FindBy(xpath = "//div[@id='password']//input")
	WebElement emailpassword;
	@FindBy(xpath = "//div[@id='passwordNext']")
	WebElement passwordnext;
	@FindBy(xpath = "//div[@id='view_container']/div/div/div[1]/content/div/div/div[2]")
	WebElement removemailidlink;
	@FindBy(xpath = "//div[@id='view_container']//button[contains(text(),'Remove an account')]")
	WebElement RemoveanAccount;
	
	public boolean Login_Page() throws Exception {
		boolean isvalidDashBoardContact = true;
		
		CommonUtil.highlightElement(driver,EmailorPhonenumber );
		EmailorPhonenumber.sendKeys("flextrio123");
		Thread.sleep(2000);
		CommonUtil.highlightElement(driver, Emailnextbtn);
		CommonUtil.captureScreenshot(driver, moduleName, "Email");
		Emailnextbtn.click();
		Thread.sleep(2000);
		CommonUtil.highlightElement(driver,emailpassword );
		emailpassword.sendKeys("Flex@123");
		Thread.sleep(2000);
		CommonUtil.highlightElement(driver,passwordnext );
		CommonUtil.captureScreenshot(driver, moduleName, "pass");
		passwordnext.click();
		Thread.sleep(2000);
		
		return isvalidDashBoardContact;
	} 
}
	