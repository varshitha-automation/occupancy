package com.qa.occupancy.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.occupancy.base.TestBase;

public class SmsPage extends TestBase {
	
	public SmsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="sales-by-traffic-tab")
	WebElement smsTab;
	
	@FindBy(xpath="//strong[text()='SMS URL']")
	WebElement url;
	
	@FindBy(id="smsUrl")
	WebElement smsUrl;          //Sms Url details saved.
	
	@FindBy(xpath="//div[@style='color:red']")
	WebElement colorRed;
	
	@FindBy(id="btnAddSmsUrl")
	WebElement addSmsUrl;
	
	@FindBy(id="btnUpdateGroup")
	WebElement updateBtn;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	 WebElement entryInfo;
	
	@FindBy(id="lblSMS")
	WebElement smsGrp;
	
	@FindBy(id="gName")
	WebElement grpName;
	
	@FindBy(id="gcName")
	WebElement contactName;
	
	@FindBy(id="gcNum")
	WebElement contactNum;
	
	@FindBy(id="btnAddContact")
	WebElement contactBtn;
	
	@FindBy(id="contactOList")
	WebElement contactList;
	
	@FindBy(xpath="//span[text()='Select Threshold(s)']")
	WebElement selTh;
	
	@FindBy(xpath="//span[text()='Select Zone(s)']")
	WebElement selZones;
	
	@FindBy(id="btnAddGroup")
	WebElement addGrp;
	
	@FindBy(xpath="//strong[text()='Group Details']")
	WebElement grpDetail;
	
	@FindBy(id="btnYes")
	WebElement yes;
	
	private void waitForElement(WebDriver driver,WebElement ele,int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
		 .until(ExpectedConditions.elementToBeClickable(ele));
	
	}
	
	
	public void editContactDetails(String contact)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+contact+"')]/following-sibling::a[2]")).click();
	}
	
	public void deleteContactDetails(String contact)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+contact+"')]/following-sibling::a[1]")).click();
	}
	
	public boolean checkEditGrpDetails(String name)
	{
		boolean text=driver.findElements(By.xpath("//td[text()='"+name+"']")).size()>0;
		if(text==true)
		{
			return true;
		}
		return false;
	}
	
	public void editGrpDetails(String name)
	{
		WebElement e = driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td/a/i[@class='mdi mdi-lead-pencil']"));
		/*new WebDriverWait(driver,12)
		 .until(ExpectedConditions.elementToBeClickable(e));*/
		waitForElement(driver,e,50);
		e.click();
	}

	
	public void deleteGrpDetails(String delName)
	{
		driver.findElement(By.xpath("//td[text()='"+delName+"']/following-sibling::td/a/i[@class='mdi mdi-delete']")).click();
	}
	
	public void clickTh()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		WebElement e = driver.findElement(By.xpath("//label[text()='Thresholds']/following-sibling::div"));
		waitForElement(driver,e,50);
		e.click();
	}
	
	public void clickZone()
	{
		//WebElement r=driver.findElement(By.xpath("//label[text()='Zones']/following-sibling::div//div/button"));
	// title = "";
		String t=driver.findElement(By.xpath("//label[text()='Zones']/following-sibling::div//div/button")).getAttribute("title");
		if(t.contains("Select Zone(s)"))
		{
			WebElement r =	driver.findElement(By.xpath("//label[text()='Zones']/following-sibling::div//div/button"));
			waitForElement(driver,r,50);
			JavascriptExecutor exe = (JavascriptExecutor)driver;
			exe.executeScript("arguments[0].click()", r);
		}
		else
		{
			WebElement r =driver.findElement(By.xpath("//label[text()='Zones']/following-sibling::div//div/button"));
			waitForElement(driver,r,50);
			JavascriptExecutor exe = (JavascriptExecutor)driver;
			exe.executeScript("arguments[0].click()", r);
		}
	}
	
	
	public void smsClick()
	{
		smsTab.click();
	}
	
	public void urlClick()
	{
		url.click();
	}
	
	public void smsUrl()
	{
		smsUrl.clear();
		smsUrl.sendKeys(prop.getProperty("SmsUrl"));
	}
	
	public String addSms()
	{
		addSmsUrl.click();
		String text=entryInfo.getText();
		return text;
	}
	
	public boolean addGrp(String gName, String cName, String cNum)
	{
		smsGrp.click();
		//waitForElement(grpName,10);
		grpName.sendKeys(gName);
		contactName.sendKeys(cName);
		contactNum.sendKeys(cNum);
		contactBtn.click();
		if(driver.findElements(By.xpath("//div[@class='ui-pnotify-text']")).isEmpty())
		{
		return true;
		}
		return false;
	}
	
	public void editContact(String gName, String cName, String cNum)
	{
		grpName.clear();
		grpName.sendKeys(gName);
		contactName.clear();
		contactName.sendKeys(cName);
		contactNum.clear();
		contactNum.sendKeys(cNum);
		contactBtn.click();
	}
	
	public void thAdd()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		selTh.click();
	}
	
	public void zoneAdd()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", selZones);
	}
	
	public String save()
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", addGrp);
		String text=entryInfo.getText();
		return text;
	}
	
	public void grpDetail()
	{
		grpDetail.click();
	}
	
	public String update()
	{
		waitForElement(driver,updateBtn,50);
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", updateBtn);
		String text=entryInfo.getText();
		return text;
	}
	
	public void delYes()
	{
		yes.click();
	}
}
