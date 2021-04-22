package com.qa.occupancy.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.occupancy.base.TestBase;

public class DashboardSettingPage extends TestBase {
	
	public DashboardSettingPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Dashboard Settings']")
	WebElement dashboard;
	
	@FindBy(xpath="//strong[text()='Live Dashboard Details']")
	WebElement liveDashboard;
	
	@FindBy(xpath="//input[@id='cbOccPer']/parent::label")
	WebElement occPercent;
	
	@FindBy(id="cbResetCount")
	WebElement cbResetCount;
	
	@FindBy(id="opMsg")
	WebElement opMsg;
	
	@FindBy(id="clMsg")
	WebElement clMsg;
	
	@FindBy(id="subOpMsg")
	WebElement subOpMsg;
	
	@FindBy(id="subClMsg")
	WebElement subClMsg;
	
	@FindBy(xpath="//div[@style='color:red; font-size: 13px']/following-sibling::div/button")
	WebElement save;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	 WebElement entryInfo;
	
	public void dashboard()
	{
		opMsg.clear();
		opMsg.sendKeys("open msg");
		clMsg.clear();
		clMsg.sendKeys("closed msg");
		subOpMsg.clear();
		subOpMsg.sendKeys("sub open msg");
		subClMsg.clear();
		subClMsg.sendKeys("sub close msg");
	}
	
	public boolean saveBtn()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		save.click();
		String h=entryInfo.getText();
		if(h.contains("Dashboard Settings saved."))
		{
			return true;
		}
		return false;
	}
	
	public void selectCheckBox(String name)
	{
		/*if(occPercent.isSelected() || cbResetCount.isSelected())
		{
			occPercent.click();
			cbResetCount.click();
		}*/
	    String text=occPercent.getText();
	    String text1=text.trim();
	    if(text1.contains(name))
	    {
	    	occPercent.click();
	    }
	    else
	    {
	    	cbResetCount.click();
	    }
	    
	}
	
	public void dashboardClick()
	{
		dashboard.click();
	}
	
	public void liveDashboard()
	{
		liveDashboard.click();
	}

}
