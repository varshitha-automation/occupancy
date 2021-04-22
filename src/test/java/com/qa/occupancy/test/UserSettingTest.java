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
import com.qa.occupancy.pages.UserSettingPage;

public class UserSettingTest extends TestBase {

	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	LiveSettingPage livesettingpage;
	ThresholdPage thresholdpage;
	SmsPage smspage;
	EmailSettingPage emailsettingpage;
	DashboardSettingPage dashboardsettingpage;
	UserSettingPage usersettingpage;
	
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
		usersettingpage=new UserSettingPage(); 
		rollingdashpage=loginpage.login();
		livesettingpage=rollingdashpage.adminBtn();	
	}
	
	@Test
	
	public void pwdAdd()
	{
		usersettingpage.userClick();
		usersettingpage.userBtnClick();
		boolean j=	usersettingpage.pwdSet();
		Assert.assertTrue(j);
	}
}
