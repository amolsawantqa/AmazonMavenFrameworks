package amazon.framework.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
		
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) 
	{
		System.out.println("In start application");
		 if(browserName.equals("Chrome"))
		 {
			 System.out.println("In chrome");
			 System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		 }else if(browserName.equals("FireFox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
			 
		 }else if(browserName.equals("IE"))
		 {
			 System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			 driver =  new InternetExplorerDriver();			 
		 }
		 else
		 {
			 System.out.println("we do not support these browsers");
		 }
		
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.get(appURL);
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Exception in sleep thread");
		}
		 System.out.println("out start application");
		 return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.close();
	}
}
