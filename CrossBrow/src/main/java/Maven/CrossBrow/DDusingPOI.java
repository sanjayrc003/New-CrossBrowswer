package Maven.CrossBrow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDusingPOI {
	
	static List<String> usernamelist=new ArrayList<String>();
	/*Initializing the Username datas in list which is in string format*/
	
	static List<String> passwordlist=new ArrayList<String>();
	/*Initializing the Password datas in list which is in string format*/
	
	public void readExcel() throws IOException
	/*Created a method readExcel for all the excel operation*/
	{
		FileInputStream f= new FileInputStream("C:\\Users\\USER\\Desktop\\Testing\\DDPOI.xlsx");
		/*Initializing the input stream of the Excel and its appropriate location*/
		
		Workbook wb=new XSSFWorkbook(f);
		/*Initializing the XSSFWorkbook as this allows user to access 2007 or later versions of Excel format */
		
		Sheet sheet=wb.getSheet("Sheet2");
		/*Initializing the Sheet for the created Workbook and sheet name is provided*/
		
		Iterator<Row> rowit=sheet.iterator();
		/*Using Iterator function to iterate the number of row values in the sheet mentioned*/
		
		while(rowit.hasNext()) 
		/*using while loop, if the initial row cell has more row elements the loop will execute*/
		{
			Row rowvalue=rowit.next();
			/*the Row value is stored in a object and next iteration will takes place*/
			
			Iterator<Cell> colit=rowvalue.iterator();
			/*Now we are initializing the Column values here column values will be identified as cell*/
			
			int i=2;
			/*I have initialized the i value inorder to segregate the two columns differently for eg: all the 
			 * even numbers will be column1(username) and odd numbers are column2(password)*/
			
			while(colit.hasNext())
			/*Now using while loop for iterating the column values*/	
				
			{
				if(i%2==0)
				{
					usernamelist.add(colit.next().getStringCellValue());
				}else
				{
					passwordlist.add(colit.next().getStringCellValue());
				}
				
				i++;
				/*incrementing the iteration*/
			}
		
		}	
		
	}

	public void login(String uname, String pword)
	/*created a method for login where i have initialized the webdriver and given the inputs as parameters*/
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Browsers\\chrome\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.get("https://www.taxbandits.com/");
		d.findElement(By.cssSelector("#navbar-collapse > ul > li.signin1.signinDesk > a")).click();
		d.findElement(By.id("LEmailAddress")).sendKeys(uname);
		d.findElement(By.id("Password")).sendKeys(pword);
		d.quit();
		
	}
	
	public void executeTest()
	/*created a method for execute test this declares how many times the test has to be runned; 
	 * here this is based on the datas we are provided*/
	{
		for(int i=0; i<usernamelist.size();i++)
		{
			login(usernamelist.get(i),passwordlist.get(i));
		}
	}
	public static void main(String[] args) throws IOException {
		/*Main method where i have created object for the methods and executed them*/
		DDusingPOI poi=new DDusingPOI();
		poi.readExcel();
		System.out.println("UserName List"+ usernamelist);
		System.out.println("Password List"+ passwordlist);
		poi.executeTest();
		
	}

}