package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class w2taxfiling {
	
	public static WebElement inipword(WebDriver d)
	{
		return d.findElement(By.id("cdnPassword"));
	}
	
	public static WebElement cntnu(WebDriver d)
	{
		return d.findElement(By.id("btnCdnSubmit"));
	}
	
	public static WebElement uname(WebDriver d)
	{
		return d.findElement(By.id("LEmailAddress"));
	}
	
	public static WebElement pword(WebDriver d)
	{
		return d.findElement(By.id("Password"));
	}
	
	public static WebElement loginbtn(WebDriver d)
	{
		return d.findElement(By.id("btnSubmit"));
	}
	
	public static WebElement notification(WebDriver d)
	{
		return d.findElement(By.id("noReturnDiv"));
	}
	
	public static WebElement navigatetaxform(WebDriver d)
	{
		return d.findElement(By.cssSelector("#WageTaxForms > table.form_table.start-tab-content > tbody > tr > td.form_com_button.formBtnRt > #w2"));
	}
	
	
	

}
