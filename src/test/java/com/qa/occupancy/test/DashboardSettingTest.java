package com.qa.occupancy.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;
import com.qa.occupancy.pages.DashboardSettingPage;
import com.qa.occupancy.pages.EmailSettingPage;
import com.qa.occupancy.pages.LiveSettingPage;
import com.qa.occupancy.pages.LoginPage;
import com.qa.occupancy.pages.RollingDashPage;
import com.qa.occupancy.pages.SmsPage;
import com.qa.occupancy.pages.ThresholdPage;

public class DashboardSettingTest extends TestBase {
	
	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	LiveSettingPage livesettingpage;
	ThresholdPage thresholdpage;
	SmsPage smspage;
	EmailSettingPage emailsettingpage;
	DashboardSettingPage dashboardsettingpage;
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		rollingdashpage =new RollingDashPage();
		testutil=new TestUtil();
		thresholdpage=new ThresholdPage();
		smspage=new SmsPage();
		emailsettingpage=new EmailSettingPage();
		dashboardsettingpage=new DashboardSettingPage();
		rollingdashpage=loginpage.login();
		livesettingpage=rollingdashpage.adminBtn();	
	}
	
	@Test
	public void addDashboardDetails() throws InterruptedException
	{
		dashboardsettingpage.dashboardClick();
		dashboardsettingpage.liveDashboard();
		Thread.sleep(9000);
		dashboardsettingpage.selectCheckBox("Occupancy Percentage");
		Thread.sleep(9000);
		dashboardsettingpage.dashboard();
		boolean b=dashboardsettingpage.saveBtn();
		Assert.assertTrue(b);
	}

}
