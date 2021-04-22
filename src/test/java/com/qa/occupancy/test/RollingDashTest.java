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

public class RollingDashTest extends TestBase {

	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	LiveSettingPage livesettingpage;
	Dashboard1Page dashboard1page;
	Dashboard2Page dashboard2page;
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		rollingdashpage =new RollingDashPage();
		testutil=new TestUtil();
		rollingdashpage=loginpage.login();
	}
	
	@Test(priority=1)
	public void adminSelect()
	{
		livesettingpage=rollingdashpage.adminBtn();
		//rollingdashpage.adminBtn();
		//testutil.suggetionBox("Live Settings");
	}
	
	@Test(priority=4)
	public void selectDash1()
	{
		dashboard1page=rollingdashpage.clickDash1();
	}
	
	@Test(priority=2)
	
	public void headingTest()
	{
		String headingText=rollingdashpage.heading();
		Assert.assertEquals(headingText,"Rolling Dashboard","not matched");
	}
	
	@Test(priority=3)
	public void timeStampTest()
	{
		boolean time=rollingdashpage.timeStamp();
		Assert.assertTrue(time);
	}
	
	@Test(priority=5)
	public void selectDash2()
	{
		dashboard2page=rollingdashpage.clickDash2();
	}
	
	@Test(priority=6)
	public void logout()
	{
		rollingdashpage.Logout();
	}
	
	
    @AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
}

