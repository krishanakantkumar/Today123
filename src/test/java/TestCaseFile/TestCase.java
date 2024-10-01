package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectFile.LoginWebElement;
import UtilitiesFile.DataDrivenTesting;




public class TestCase extends BaseClass
{
	@Test (dataProvider ="DataPro")
	
	 void openurl(String user,String Pass)
	{
		driver.get(url);
		Log1.info("open url");
		LoginWebElement l1=new LoginWebElement(driver);
		l1.user_name(user);
		Log1.info("Enter the user name");
		l1.pass_name(Pass);
		Log1.info("Enter the password");
		l1.submit1();
		Log1.info("Click on submit button");
	}
	@DataProvider(name="DataPro")
	public String[][] SearchData() throws Exception 
	{
		String filename= "C:\\Users\\abhay\\OneDrive\\Desktop\\hello.xlsx";
		int row=DataDrivenTesting.getRow(filename, "Sheet1");
		int col=DataDrivenTesting.getCol(filename, "Sheet1");
		String s1 [][]=new String [row-1][col];
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				s1[i-1][j]= DataDrivenTesting.getCellValue(filename, "Sheet1", i,j);
			}
		}
		return s1;
	}
	
	
		
}	


