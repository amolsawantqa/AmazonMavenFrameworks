package amazon.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

	WebDriver driver;
	
	public SearchResultPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement searchtext;
	@FindBy(xpath="//input[@type='submit' and @value='Go']")WebElement searchbutton;
	
	
	public void displayFirstElement()
	{
		searchtext.sendKeys("Smart TV");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchbutton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = driver.findElement(By.xpath("//span[@class='sb_3vapQDdI sb_2Jsx-Yw7']")).getText();
		System.out.print(name);
	}
	
}
