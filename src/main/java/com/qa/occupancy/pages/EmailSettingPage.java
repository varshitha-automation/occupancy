package com.qa.occupancy.pages;

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

public class EmailSettingPage extends TestBase {
	
	public EmailSettingPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Email Settings']")
	WebElement email;
	
	@FindBy(xpath="//strong[text()='SMTP Configuration']")
	WebElement smtp;
	
	@FindBy(id="smServer")
	WebElement smServer;
	
	@FindBy(id="smPort")
	WebElement smPort;
	
	@FindBy(id="smUserName")
	WebElement smUserName;
	
	@FindBy(id="emSsl")
	WebElement emSsl;
	
	@FindBy(id="smPwd")
	WebElement smPwd;
	
	@FindBy(id="btnsmtp")
	WebElement saveBtn;
	
	@FindBy(id="btnSubmit")
	WebElement submit;
	
	@FindBy(xpath="//strong[text()='Add Email']")
	WebElement addEmailBtn;
	
	@FindBy(id="eName")
	WebElement eName;
	
	@FindBy(id="eEmail")
	WebElement eEmail;
	
	@FindBy(id="btnAddEmail")
	WebElement arrowBtn;
	
	@FindBy(id="btnAddEmGroup")
	WebElement addEmailGrp;
	
	@FindBy(xpath="//span[text()='Select Threshold(s)']")
	WebElement selTh;
	
	@FindBy(xpath="//strong[text()='Email Details']")
	WebElement addEmailDetailsBtn;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	 WebElement entryInfo;
	
	  String[] emails = new String[]{
	          "email1@gmail.com",
	          "email2@gmail.com",
	          "email4@gmail.com"
	        };
	  
	private void clickIntercepted(WebElement e)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", e);
	}
	
	private void waitForElement(WebDriver driver,WebElement ele,int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
		 .until(ExpectedConditions.elementToBeClickable(ele));
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
	public void editEmailDetails(String name)
	{
		WebElement e = driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td/a/i[@class='mdi mdi-lead-pencil']"));
		/*new WebDriverWait(driver,12)
		 .until(ExpectedConditions.elementToBeClickable(e));*/
		waitForElement(driver,e,50);
		e.click();
	}

	
	public void deleteEmailDetails(String delName)
	{
		driver.findElement(By.xpath("//td[text()='"+delName+"']/following-sibling::td/a/i[@class='mdi mdi-delete']")).click();
	}
	
	public void emailClick()
	{
		email.click();
	}
	
	public void smtpClick()
	{
		smtp.click();
	}
	public boolean saveClick()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		clickIntercepted(saveBtn);
		if(driver.findElements(By.xpath("//div[@class='ui-pnotify-text']")).isEmpty())
		{
		return true;
		}
		return false;
	}
	
	public boolean submitBtn()
	{
		submit.click();
		if(driver.findElements(By.xpath("//div[@class='ui-pnotify-text']")).isEmpty())
		{
		return true;
		}
		return false;
	}
	
	public void addSmtpDetails()
	{
		smServer.clear();
		smServer.sendKeys("smtp.gmail.com");
		smPort.clear();
		smPort.sendKeys("587");
		smUserName.clear();
		smUserName.sendKeys("delopt.in@gmail.com");
		smPwd.clear();
		smPwd.sendKeys("isecure123");
		if(!(emSsl.isSelected()))
		{
			emSsl.click();
		}
	}
	
	public void addEmailBtn()
	{
		addEmailBtn.click();
	}
	
	public void addEmailGrp()
	{
		
		clickIntercepted(addEmailGrp);
	}
	
	public boolean addEmail()
	{
			eName.sendKeys("emailGrp");
			for(String email:emails)
			{
			eEmail.sendKeys(email);
			arrowBtn.click();
				if(driver.findElements(By.xpath("//div[@class='ui-pnotify-text']")).size()>0)
				{
					return false;
				}
			}

			return true;
 }

}