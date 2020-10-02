package amazon.framework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import amazon.framework.pages.SearchResultPage;

public class TestItemSearch extends BaseClass
{

	@Test
	public void ItemSearchTest1() 
	{
		//System.out.println("Test case 2");
		
		logger = report.createTest("Amazon Item Search Test 1");
		//SearchResultPage resultpage = PageFactory.initElements(driver, SearchResultPage.class);
		logger.info("Test Started");
		//resultpage.displayFirstElement();
		//logger.pass("Test passed");
	}
	@Test
	public void ItemSearchTest2() 
	{
		//System.out.println("Test case 2");
		
		logger = report.createTest("Amazon Item Search Test 2");
		//SearchResultPage resultpage = PageFactory.initElements(driver, SearchResultPage.class);
		logger.info("Test Started");
		//resultpage.displayFirstElement();
		//logger.pass("Test passed");
	}
	@Test
	public void ItemSearchTest3() 
	{
		//System.out.println("Test case 2");
		
		logger = report.createTest("Amazon Item Search Test 3");
		//SearchResultPage resultpage = PageFactory.initElements(driver, SearchResultPage.class);
		logger.info("Test Started");
		//resultpage.displayFirstElement();
		//logger.pass("Test passed");
	}
	
}
