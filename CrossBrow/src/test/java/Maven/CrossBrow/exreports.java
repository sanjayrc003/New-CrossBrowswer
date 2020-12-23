package Maven.CrossBrow;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;

public class exreports {
	
	WebDriver d;
	ExtentReports exerep;
	ExtentHtmlReporter htmlrep;
	ExtentTest testcase;
	String driver_path= System.getProperty("user.dir") +"/src/main/java/com/crossbrowser/driver/chromedriver.exe";
	
	
	@BeforeClass
	public void startTest()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Browsers\\chrome\\chromedriver.exe");
	d=new ChromeDriver();
	
	//htmlrep=new HTMLReporter("C:\\Users\\USER\\Desktop\\Testing\\ExtentReports\\ExtentReport.html");
	htmlrep = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
	exerep=new ExtentReports();
	exerep.attachReporter(htmlrep);
	}
	
	
	@Test
	public void opengoogle()
	{
		testcase=exerep.createTest("Verify Google");
		d.get("https://www.google.com/");
		testcase.log(Status.INFO, "Navigating to Google");
		String title=d.getTitle();
		if(title.equals("Google"))
		{
			testcase.log(Status.PASS, "Actual Title and Expected Title are Equal");
		}
		else
		{
			testcase.log(Status.FAIL, "Actual Title and Expected Title are not Equal");
		}
	
	}
	
	
	
	@AfterClass
	public void endTest()
	{
		d.quit();
		exerep.flush();
	
	}
	}

