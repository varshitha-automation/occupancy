package com.qa.occupancy.test;

import java.io.IOException;

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
import com.qa.occupancy.pages.ThresholdPage;

public class ThresholdTest extends TestBase {
	
	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	LiveSettingPage livesettingpage;
	ThresholdPage thresholdpage;
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		rollingdashpage =new RollingDashPage();
		testutil=new TestUtil();
		thresholdpage=new ThresholdPage();
		rollingdashpage=loginpage.login();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		livesettingpage=rollingdashpage.adminBtn();		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		TestUtil testutil=new TestUtil();
		Object[][] d=testutil.excelData("addThreshold");
		return d;
	}
	
	@DataProvider
	public Object[][] getEditData()
	{
		TestUtil testutil=new TestUtil();
		Object[][] d=testutil.excelData("editThreshold");
		return d;
	}
	
	@Test(priority=1,dataProvider="getData")
	
	public void addTh(String tname, String descrip, String thStart, String thEnd, String dur ) throws InterruptedException
	{
		Thread.sleep(9000);
		thresholdpage.thresholdBtn();
		thresholdpage.addTh();
		thresholdpage.addTh(tname, descrip, thStart, thEnd, dur);
		testutil.SMS("2");
		String text=thresholdpage.saveBtn();
		Assert.assertEquals(text,"Threshold details saved.");
	}
	
	@Test(priority=2,dataProvider="getEditData")
	
	public void editAddTh(String tname, String descrip, String thStart, String thEnd, String dur) throws InterruptedException
	{
		Thread.sleep(9000);
		thresholdpage.thresholdBtn();
		thresholdpage.editTh();//details
		Thread.sleep(9000);
		thresholdpage.editThDetails("ThZone");
		thresholdpage.editTh(tname, descrip, thStart, thEnd, dur);
		testutil.SMS("2");
		thresholdpage.update();
		String text=thresholdpage.saveBtn();
		Assert.assertEquals(text,"Threshold details saved.");
	}
	
	@Test(priority=3)
	
	public void deleteTh() throws InterruptedException
	{
		Thread.sleep(9000);
		thresholdpage.thresholdBtn();
		thresholdpage.editTh();//details
		thresholdpage.deleteThDetails("test");
		String text=thresholdpage.deleteOK();
		Assert.assertEquals(text,"test is deleted.");
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
}
