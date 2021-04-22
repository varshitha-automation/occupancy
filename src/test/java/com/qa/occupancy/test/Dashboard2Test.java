package com.qa.occupancy.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;
import com.qa.occupancy.listener.Testlistener;
import com.qa.occupancy.pages.Dashboard1Page;
import com.qa.occupancy.pages.Dashboard2Page;
import com.qa.occupancy.pages.LiveSettingPage;
import com.qa.occupancy.pages.LoginPage;
import com.qa.occupancy.pages.RollingDashPage;

@Listeners(Testlistener.class)
public class Dashboard2Test extends TestBase {
	
	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	Dashboard1Page dashboard1page;
	Dashboard2Page dashboard2page;
	LiveSettingPage livesettingpage;
	
	public static Logger log = LogManager.getLogger(Dashboard2Test.class);
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		log.info("driver initialized");
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
		dashboard2page=rollingdashpage.clickDash2();
	}
	
	@Test(priority=1)
	public void dropDwonTest()
	{
		String dropDownName=dashboard2page.dropDown();
		String h=dashboard2page.zonetitle();
		if(h.equalsIgnoreCase(dropDownName))
		{
			Assert.assertTrue(true);
			log.info("test passed");
		}
		else
		{
			Assert.assertTrue(false);
		log.info("error occured");
		}
	}
	
	//@Test(priority=2)
	public void clock()
	{
		boolean n=dashboard2page.clock();
		Assert.assertTrue(n);
	}
	
	//@Test(priority=3)
	public void headingTest()
	{
		String h=dashboard2page.mainHeading();
		Assert.assertEquals("Dashboard 2", h);
	}
	
	@Test(priority=4)
	public void adminSelect()
	{
		livesettingpage=dashboard2page.adminBtn();
		log.info("live setting page opened");
	}
	
	//@Test(priority=5)
	public void selectDash2()
	{
		dashboard1page=dashboard2page.clickDash1();
	}
	
	//@Test(priority=6)
	public void logout()
	{
		dashboard2page.Logout();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		/*if(result.getStatus() == ITestResult.FAILURE)
		{
		testutil.screenShot(result.getMethod().getMethodName());
		}*/
		driver.quit();
	}

}
