package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objects.w2taxfiling;

public class testrun {
	
	WebDriver d;
	
	String [][] data= null;
	
	public String[][] exceldata() throws IOException


	{
		FileInputStream f=new FileInputStream("C:\\Users\\USER\\Desktop\\Testing\\DDPOI.xlsx");
		
		
		Workbook wb=new XSSFWorkbook(f);
		
		
		Sheet sheet=wb.getSheet("Sheet3");
		

		String[][] testdata=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		
		{
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
		
		{
		testdata[i][j]=sheet.getRow(i+1).getCell(j).toString();
		
		}
		}
		return testdata;
			
		}

		@DataProvider(name="logindata")
		public String[][] loginDP() throws IOException
		{
			data=exceldata();
			
			return data;
		}
	
	/*@Beforetest
	public void beforetest()
	{
		
	}*/
	
	
	@Test(dataProvider="logindata")
	public void sprint(String username, String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Browsers\\chrome\\chromedriver.exe");
		d=new ChromeDriver();
		d.get("https://tbscoreapp.taxvari.com/");
		w2taxfiling.inipword(d).sendKeys("imtesting");
		w2taxfiling.cntnu(d).click();
		w2taxfiling.uname(d).sendKeys(username);
		Thread.sleep(5000);
		//d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		w2taxfiling.pword(d).sendKeys(password);
		Thread.sleep(5000);
		//d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		w2taxfiling.loginbtn(d).click();
		//d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//w2taxfiling.notification(d).click();
		//w2taxfiling.navigatetaxform(d).click();
	}

}
