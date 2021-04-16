package com.qa.occupancy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.occupancy.base.TestBase;

public class ThresholdPage extends TestBase {
	
	public ThresholdPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="server-loading-tab")
	WebElement threshold;
	
	@FindBy(id="lblThreshold")
	WebElement addThreshold;
	
	@FindBy(id="thName")
	WebElement thName;
	
	@FindBy(id="thDesp")
	WebElement thDesp;
	
	@FindBy(id="thStart")
	WebElement thStartNum;
	
	@FindBy(id="thEnd")
	WebElement thEndNum;
	
	@FindBy(id="thDuration")
	WebElement thDuration;
	
	@FindBy(id="btnAddThreshold")
	WebElement addThresholdBtn;
	
	@FindBy(id="btnUpdateThreshold")
	WebElement update;
	
	@FindBy(id="btnYes")
	WebElement delYes;
	
	@FindBy(xpath="//strong[text()='Threshold Details']")
	WebElement editThbtn;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	 WebElement entryInfo;
	
	
	public void thresholdBtn()
	{
		threshold.click();
	}
	
	public void addTh()
	{
		addThreshold.click();
	}
	
	public void editTh()
	{
		editThbtn.click();
	}
	
	public String update()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", update);
		String text=entryInfo.getText();
		return text;
	}
	
	public String deleteOK()
	{
		delYes.click();
		String text=entryInfo.getText();
		return text;
	}
	
	public void editThDetails(String name)
	{
		driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td/a/i[@class='mdi mdi-lead-pencil']")).click();
		
	}
	
	public void deleteThDetails(String delName)
	{
		driver.findElement(By.xpath("//td[text()='"+delName+"']/following-sibling::td/a/i[@class='mdi mdi-delete']")).click();
	}
	
	public void addTh(String tName, String desc, String thStart, String thEnd, String duration)
	{
		thName.sendKeys(tName);
		thDesp.sendKeys(desc);
		thStartNum.sendKeys(thStart);
		thEndNum.sendKeys(thEnd);
		thDuration.sendKeys(duration);
	}
	
	public String saveBtn()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", addThresholdBtn);
		String text=entryInfo.getText();
		return text;
	}
	
	public void editTh(String tName, String desc, String thStart, String thEnd, String duration)
	{
		thName.clear();
		thName.sendKeys(tName);
		thDesp.clear();
		thDesp.sendKeys(desc);
		thStartNum.clear();
		thStartNum.sendKeys(thStart);
		thEndNum.clear();
		thEndNum.sendKeys(thEnd);
		thDuration.clear();
		thDuration.sendKeys(duration);

	}

}
