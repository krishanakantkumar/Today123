package PageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebElement
{
	WebDriver ldriver;
	public LoginWebElement(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(id="username") WebElement user1;
	@FindBy(id="password") WebElement pass1;
	@FindBy(id="submit") WebElement sub1;
	
	public void user_name(String u)
	{
	user1.sendKeys(u);	
	}
	public void pass_name(String p)
	{
		pass1.sendKeys(p);
	}
	public void submit1 ()
	{
		sub1.click();
	}	


}
