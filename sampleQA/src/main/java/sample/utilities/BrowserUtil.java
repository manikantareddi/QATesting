package sample.utilities;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

	public class BrowserUtil {
		static WebDriver driver; 

		
		public static WebDriver StartBrowser(String browserName, String url, Boolean isHeadless) {
			
			return CheckforexecutionType(isHeadless, url, browserName);		
				  
		}
		
		
		public static WebDriver CheckforexecutionType(boolean isHeadless, String url, String browserName)
		{
			WebDriver driver = null;
			String PATH_TO_PACKAGE = System.getProperty("user.dir");
			if(isHeadless)
			{
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setJavascriptEnabled(true);			
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,PATH_TO_PACKAGE+"\\Resources\\phantomjs.exe");	
				System.setProperty("webdriver.gecko.driver",PATH_TO_PACKAGE+"\\Resources\\geckodriver.exe");
				driver = new PhantomJSDriver(caps);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.get(url);
			}
			else
			{
					if (browserName.equalsIgnoreCase("chrome")) {
					   System.setProperty("webdriver.chrome.driver", PATH_TO_PACKAGE + "\\Resources\\chromedriver.exe");
					   ChromeOptions o = new ChromeOptions();
					   o.addArguments("disable-extensions");
					   o.addArguments("--start-maximized");
					   o.addArguments("disable-infobars");
					   driver = new ChromeDriver(o);   
//					   driver.manage().window().maximize();
					   driver.manage().deleteAllCookies();
					   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					   driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);   
					       
					  } else if (browserName.equalsIgnoreCase("Firefox")) {
					   driver = new FirefoxDriver();
					  }
					  driver.get(url);
				
			}
			
			return driver;
		}


	}

