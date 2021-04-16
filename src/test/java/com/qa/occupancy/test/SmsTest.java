package com.qa.occupancy.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;
import com.qa.occupancy.pages.LiveSettingPage;
import com.qa.occupancy.pages.LoginPage;
import com.qa.occupancy.pages.RollingDashPage;
import com.qa.occupancy.pages.SmsPage;
import com.qa.occupancy.pages.ThresholdPage;

public class SmsTest extends TestBase {

	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	LiveSettingPage livesettingpage;
	ThresholdPage thresholdpage;
	SmsPage smspage;
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		rollingdashpage =new RollingDashPage();
		testutil=new TestUtil();
		thresholdpage=new ThresholdPage();
		smspage=new SmsPage();
		rollingdashpage=loginpage.login();
		livesettingpage=rollingdashpage.adminBtn();	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		TestUtil testutil=new TestUtil();
		Object[][] d=testutil.excelData("SmsGrp");
		return d;
	}
	@DataProvider
	public Object[][] getDataEditContact()
	{
		TestUtil testutil=new TestUtil();
		Object[][] d=testutil.excelData("editSms");
		return d;
	}
	
	@Test(priority=1)
	public void test()
	{
		smspage.smsClick();
		smspage.urlClick();
		smspage.smsUrl();
		String t=smspage.addSms();
		Assert.assertEquals(t,"Sms Url details saved.");
	}
	
    @Test(priority=2,dataProvider="getData")
	public void addGrpSms(String name,String conName,String conContact)
	{
		smspage.smsClick();
		boolean check=smspage.addGrp(name, conName, conContact);
		Assert.assertTrue(check);
		smspage.thAdd();
		testutil.addLineSuggetionBox("editTh");
		smspage.zoneAdd();
		testutil.addLineSuggetionBox("red");
		String text=smspage.save();
		Assert.assertEquals(text, "Group details saved.");
	}
	
	//@Test(priority=3,dataProvider="getDataEditContact")
	public void editGrp(String name,String conName,String conContact) throws InterruptedException
	{
		smspage.smsClick();
		smspage.grpDetail();
		boolean t=smspage.checkEditGrpDetails("j");
		if (t== true)
		{
		smspage.editGrpDetails("r");
		smspage.editContact(name, conName, conContact);
		smspage.clickTh();
		testutil.selectCheckBox("threshold test");
		smspage.clickZone();
		testutil.selectCheckBox("f");
		String check=smspage.update();
		Assert.assertEquals("Group details saved.", check);
		}
		else
		{
			Assert.assertEquals(true, t,"group not found to edit");
		}
	}
	
	@Test
	public void delete()
	{
		smspage.smsClick();
		smspage.grpDetail();
		smspage.deleteGrpDetails("Group1");
		smspage.delYes();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
