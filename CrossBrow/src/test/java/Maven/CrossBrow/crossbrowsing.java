package Maven.CrossBrow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class crossbrowsing {
	
	@Test
	  public void f() {
		  
		  d.get("https://www.spanenterprises.com/");
		  d.findElement(By.cssSelector("#ourProduct_Menu")).click();
		  
		  f.get("https://www.spanenterprises.com/");
		  f.findElement(By.cssSelector("#ourProduct_Menu")).click();
	  }
	  
	  public WebDriver d;
	  public WebDriver f;
	  
	  @BeforeTest
	  public void beforeTest() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Browsers\\chrome\\chromedriver.exe");
		  d=new ChromeDriver();
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Desktop\\Browsers\\firefox\\geckodriver.exe");
		  f=new FirefoxDriver();
		  
		  
	  }

	  @AfterTest
	  public void afterTest() {
		  //d.quit();
		  //f.quit();
		  
	  }

	}

