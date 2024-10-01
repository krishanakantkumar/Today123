package TestCaseFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import UtilitiesFile.ReadConfigClass;
public class BaseClass 
{
	public static WebDriver driver;  
	public static Logger Log1;
	
	ReadConfigClass rc=new ReadConfigClass();
	String url=rc.geturl();                         //https://practicetestautomation.com/practice-test-log/
	String browser=rc.getbrowser();                  // Chrome 
	@BeforeClass
	void browserLaunch()
	{
		switch(browser.toLowerCase())                 //toLowerCase is use to cnvert upper case in Lower case 
		{
		case"chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case"msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case"firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			default:
				driver=null;
				break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Log1=LogManager.getLogger("MyFRAMEWORKproject");
		
		}
	public void screenshot() throws Exception 
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\abhay\\eclipse-workspace\\MyFRAMEWORKproject\\ScreenShotg\\h3.png");
		FileUtils.copyFile(source, destination);
	}
	
		
	}


