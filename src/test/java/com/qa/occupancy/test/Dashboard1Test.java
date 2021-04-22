package com.qa.occupancy.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;
import com.qa.occupancy.pages.Dashboard1Page;
import com.qa.occupancy.pages.Dashboard2Page;
import com.qa.occupancy.pages.LiveSettingPage;
import com.qa.occupancy.pages.LoginPage;
import com.qa.occupancy.pages.RollingDashPage;

public class Dashboard1Test extends TestBase {
	
	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	Dashboard1Page dashboard1page;
	Dashboard2Page dashboard2page;
	LiveSettingPage livesettingpage;
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		rollingdashpage =new RollingDashPage();
		testutil=new TestUtil();
		rollingdashpage=loginpage.login();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboard1page=rollingdashpage.clickDash1();
	}
	
	//@Test(priority=1)
	public void dropDwonTest()
	{
		String dropDownName=dashboard1page.dropDown();
		String h=dashboard1page.zonetitle();
		if(h.equalsIgnoreCase(dropDownName))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	//@Test(priority=2)
	public void clock()
	{
		boolean n=dashboard1page.clock();
		Assert.assertTrue(n);
	}
	
	@Test(priority=3)
	public void headingTest()
	{
		String h=dashboard1page.mainHeading();
		Assert.assertEquals("Dashboard 1", h);
	}
	
	@Test(priority=4)
	public void adminSelect()
	{
		livesettingpage=dashboard1page.adminBtn();
	}
	
	@Test(priority=5)
	public void selectDash2()
	{
		dashboard2page=dashboard1page.clickDash2();
	}
	
	@Test(priority=6)
	public void logout()
	{
		dashboard1page.Logout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
