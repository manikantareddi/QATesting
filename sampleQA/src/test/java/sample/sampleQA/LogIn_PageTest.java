package sample.sampleQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sample.utilities.BrowserUtil;


public class LogIn_PageTest {
	public WebDriver driver;
	String moduleName = "DashBoard";

	String profileModule = "Profile";

	@Parameters({ "browser", "site", "isHeadless" })
	@BeforeMethod
	public void OpenBrowser(String browser, String Site, Boolean isHeadless) throws Exception {
		driver = BrowserUtil.StartBrowser(browser, Site, isHeadless);
	}

	@Test(priority = 1)
	public void checkValidgmail() throws Exception {

		LogIn_Page logpage = PageFactory.initElements(driver, LogIn_Page.class);
		Assert.assertTrue(logpage.Login_Page(), "DashBoard verification verification failed.");

	}

	@AfterMethod
	public void close() throws Exception {
		driver.quit();

	}
}

