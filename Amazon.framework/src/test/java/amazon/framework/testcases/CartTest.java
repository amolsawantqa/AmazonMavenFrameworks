package amazon.framework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import amazon.framework.pages.LoginPage;


public class CartTest extends BaseClass {

	@Test
	public void MyCartTest()
	{
		logger = report.createTest("Amazon Cart Test");
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginpage.loginToAmazon(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1));
		loginpage.testMycartButton();
		logger.pass("Cart tested Success");
	}	
}
