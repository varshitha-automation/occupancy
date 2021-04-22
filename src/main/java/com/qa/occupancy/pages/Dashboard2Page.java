package com.qa.occupancy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;

public class Dashboard2Page extends TestBase { 
	
	public Dashboard2Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//li[@class='col-sm-3']/h2")
	WebElement zoneName;
	
	@FindBy(id="clock")
	WebElement clock;
	
	@FindBy(xpath="//h2[@style='padding-top:10px; font-weight: bolder; color:whitesmoke']/center")
	WebElement heading;
	
	@FindBy(xpath="//span[@class='nav-profile-name']")
	WebElement adminBtn;
	
	public String dropDown()
	{
		TestUtil testutil=new TestUtil();
		String text=testutil.selZoneDropDown("teststtest6");
		return text;
	}
	
	public String zonetitle()
	{
		String zName=zoneName.getText();
		return zName;
	}
	
	public boolean clock()
	{
		if(clock.isDisplayed())
		{
		return true;
		}
		return false;
	}
	
	public String mainHeading()
	{
		String h=heading.getText();
		return h;
	}
	
	public LiveSettingPage adminBtn()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//waitForVisibility(adminBtn);
		adminBtn.click();
		//waitForVisibilityOfElements(list);
	TestUtil testutil = new TestUtil();
	
	testutil.suggetionBox("Live Settings");
	return new LiveSettingPage();
	}
	
	public Dashboard1Page clickDash1()
	{
		adminBtn.click();
		TestUtil testutil = new TestUtil();
		testutil.suggetionBox("Dashboard 1");
		return new Dashboard1Page();
	}
	
	public void Logout()
	{
		adminBtn.click();
		TestUtil testutil = new TestUtil();
		testutil.suggetionBox("Logout");
		
	}

}
