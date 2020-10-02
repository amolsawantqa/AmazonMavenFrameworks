package amazon.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(id="ap_email") WebElement uname;
	@FindBy(xpath="//input[@type='password']") WebElement passw;
	@FindBy(xpath="//input[@id='continue']") WebElement continuebutton;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement loginbutton;
	@FindBy(xpath="//input[@id='nav-cart-count-container']")WebElement cartbutton;
	
	
	
	
	
	public void loginToAmazon(String usernameApplication, String passwordApplication) 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uname.sendKeys(usernameApplication);
		continuebutton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passw.sendKeys(passwordApplication);
		loginbutton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testpageheader()
	{
		System.out.println(driver.getTitle());
	}
	
	public void testMycartButton()
	{
		cartbutton.click();
		System.out.println(driver.findElement(By.xpath("//h1[@class='sc-empty-cart-header']")).getText());
	}
}


