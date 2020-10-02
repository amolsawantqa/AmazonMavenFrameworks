package amazon.framework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import amazon.framework.pages.LoginPage;


public class LoginTestAmazon extends BaseClass {

	@Test
	public void LoginToAmazon() 
	{
		//System.out.println("Test case 1");
		
		logger = report.createTest("Amazon Login Test");		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginpage.loginToAmazon(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1));
		loginpage.testpageheader();
		logger.pass("Login Success");
	}		
}
