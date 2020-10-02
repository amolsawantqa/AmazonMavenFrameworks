package amazon.framework.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	//Screenshots, Alerts, Frames, Windows, Sync issues, java script executor
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath = System.getProperty("user.dir")+ "./Screenshots/AmazonFramework_"+getCurrentDateTime()+".png";
		try 
		{
			FileHandler.copy(src,new File(ScreenshotPath));
			
			System.out.println("Screenshot Captured");
			
		} catch (IOException e) 
		{
			System.out.println("unable to capture Screenshot");
		}
		
		return ScreenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		return customFormat.format(new Date()); 
	}
	
}
