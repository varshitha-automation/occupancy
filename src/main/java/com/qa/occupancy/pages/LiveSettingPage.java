package com.qa.occupancy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.occupancy.base.TestBase;

public class LiveSettingPage extends TestBase {
	
	public LiveSettingPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="lblZone")
	WebElement addZoneBtn;
	
	@FindBy(id="zoneName")
	WebElement zonename;
	
	@FindBy(id="friendlyName")
	WebElement zonefriendlyname;
	
	@FindBy(id="zoneDescription")
	WebElement zoneDescription;
	
	@FindBy(id="street")
	WebElement street;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="zoneThreshold")
	WebElement zoneThreshold;

	
	@FindBy(id="zoneCapacity")
	WebElement zoneCapacity;
	
	@FindBy(id="zoneMessage")
	WebElement zoneMessage;
	
	@FindBy(xpath="//span[text()='Select Entry Line(s)']")
	WebElement addLine;
	
	@FindBy(xpath="//span[text()='Select Exit Line(s)']")
	WebElement exitLine;
	
	@FindBy(id="btnAddZone")
	WebElement btnAddZone;
	
	@FindBy(xpath="//span[text()='No Entry Line(s)']")
	WebElement test;
	
	@FindBy(xpath="//div[@class='card-body']/div[10]")
	WebElement checkLine;
	
	@FindBy(xpath="//strong[text()='Zone Details']")
	WebElement zoneDetails;
	
	@FindBy(id="btnUpdateZone")
	WebElement update;
	
	@FindBy(xpath="//label[@for='sel_serviceEntry']/parent::div/div")
	WebElement editAddLine;
	
	@FindBy(xpath="//label[@for='sel_serviceExit']/parent::div/div")
	WebElement editExitLine;
	
	@FindBy(id="rc-r_0-ResetCounts")
	WebElement reset;
	
	@FindBy(id="btnYes")
	WebElement resetOK;
	
	@FindBy(id="ResInCounts")
	WebElement inCount;
	
	@FindBy(id="btnResYes")
	WebElement ibtnYes;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	 WebElement entryInfo;
	
	@FindBy(xpath="//div[@class='alert ui-pnotify-container alert-success ui-pnotify-shadow']")
	WebElement detailsInfo;
	
	@FindBy(id="btnYes")
	WebElement deleteYes;
	
	public void addZone(String zname,String frndName,String desc,String streetName,String cityName,String countryName,String threshold,String capacity,String msg)
	{
		zonename.sendKeys(zname);
		zonefriendlyname.sendKeys(frndName);
		zoneDescription.sendKeys(desc);
		street.sendKeys(streetName);
		city.sendKeys(cityName);
		country.sendKeys(countryName);
		zoneThreshold.sendKeys(threshold);
		zoneCapacity.sendKeys(capacity);
		zoneMessage.sendKeys(msg);
	}
	
	public void addZoneDetails()
	{
		addZoneBtn.click();
	}
	
	public boolean testLine() throws InterruptedException

	{
		
		String a=checkLine.getText();
		//String t=test.getText();
		
		if(a.contains("No Entry Line(s)"))
		{
			Thread.sleep(5000);
			addZoneBtn.click();
			return true;
		}
		/* if(a.contains("Select Entry Line(s)"))
		{
		      return false;
		}*/
		
		return false;
		
	}
	public void addLine()
	{
		addLine.click();
	}
	
	public String deleteZone()
	{
		deleteYes.click();
		String text=entryInfo.getText();
		return text;
	}
	
	public void exitLine()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", exitLine);
	}
	
	public String saveBtn()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", btnAddZone);
		String text=entryInfo.getText();
		return text;
	}
	
	public void zoneDetails()
	{
		zoneDetails.click();
	}
	
	public void editZoneDetails(String name)
	{
		driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td/a/i")).click();
		
	}
	
	
	
	public void deleteZoneDetails(String delName)
	{
		driver.findElement(By.xpath("//td[text()='"+delName+"']/following-sibling::td/a[2]/i")).click();
	}
	public void detailEdit(String zname,String frndName,String desc,String streetName,String cityName,String countryName,String threshold,String capacity,String msg)
	{
		zonename.clear();
		zonename.sendKeys(zname);
		zonefriendlyname.clear();
		zonefriendlyname.sendKeys(frndName);
		zoneDescription.clear();
		zoneDescription.sendKeys(desc);
		street.clear();
		street.sendKeys(streetName);
		city.clear();
		city.sendKeys(cityName);
		country.clear();
		country.sendKeys(countryName);
		zoneThreshold.clear();
		zoneThreshold.sendKeys(threshold);
		zoneCapacity.clear();
		zoneCapacity.sendKeys(capacity);
		zoneMessage.clear();
		zoneMessage.sendKeys(msg);
	}
	
	public String update()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", update);
		String text=entryInfo.getText();
		return text;
	}
	
	public void editExitLine()
	{
		editExitLine.click();
	/*	JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", editExitLine);*/
		
	}
	
	public void editAddLine()
	{
		editAddLine.click();
		
	}
	
	public void reset()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", reset);
		
	}
	
	public void resetOK()
	{
		resetOK.click();
		
	}
	
	public void inCount()
	{
		inCount.sendKeys("5");
		
	}
	
	public void btnYes()
	{
		ibtnYes.click();
		
	}
}

