package com.qa.occupancy.test;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;
import com.qa.occupancy.pages.EmailSettingPage;
import com.qa.occupancy.pages.LiveSettingPage;
import com.qa.occupancy.pages.LoginPage;
import com.qa.occupancy.pages.RollingDashPage;
import com.qa.occupancy.pages.SmsPage;
import com.qa.occupancy.pages.ThresholdPage;

public class EmailSettingTest extends TestBase {
	
	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	LiveSettingPage livesettingpage;
	ThresholdPage thresholdpage;
	SmsPage smspage;
	EmailSettingPage emailsettingpage;
	SoftAssert soft=new SoftAssert();
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
		rollingdashpage=loginpage.login();
		livesettingpage=rollingdashpage.adminBtn();	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][1];
		data[0][0]="varshitha@gmail.com";
		data[1][0]="lll";
		return data;
	}
	
	//@Test(priority=1)
	public void smtpDetails()
	{
		emailsettingpage.emailClick();
		emailsettingpage.smtpClick();
		emailsettingpage.addSmtpDetails();
		emailsettingpage.saveClick();
		boolean b=emailsettingpage.submitBtn();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2)
	public void addEmailTest() throws InterruptedException
	{
		emailsettingpage.emailClick();
		emailsettingpage.addEmailBtn();
		boolean b=emailsettingpage.addEmail();
		soft.assertTrue(b);
		Thread.sleep(5000);
		emailsettingpage.clickTh();
		testutil.addLineSuggetionBox("editTh");
		emailsettingpage.clickZone();
		testutil.addLineSuggetionBox("f-f");
		boolean p=emailsettingpage.saveClick();
		soft.assertTrue(p);
		soft.assertAll();
	}
	
	
}
