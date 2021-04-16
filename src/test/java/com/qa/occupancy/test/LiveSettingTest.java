package com.qa.occupancy.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;
import com.qa.occupancy.pages.LiveSettingPage;
import com.qa.occupancy.pages.LoginPage;
import com.qa.occupancy.pages.RollingDashPage;

public class LiveSettingTest extends TestBase{
	
	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	TestUtil testutil;
	LiveSettingPage livesettingpage;
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		rollingdashpage =new RollingDashPage();
		testutil=new TestUtil();
		//wait=new WebDriverWait(driver,10);
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
		Object[][] d=testutil.excelData("addzone");
		return d;
	}
	
	@DataProvider
	public Object[][] getDataEdit()
	{
		TestUtil testutil=new TestUtil();
		Object[][] d=testutil.excelData("editZone");
		return d;
	}
	
	//@Test(priority=1, dataProvider="getData")
	
	public void excelData(String eZone,String eZoneFrnd,String eDesc,String estreet,String ecity,String ecountry,String eth,String ecapacity,String emsg,String EntryLine,String exitLine,String reset) throws InterruptedException
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		livesettingpage.addZoneDetails();
		
	//	livesettingpage.testLine();
		livesettingpage.addZone(eZone, eZoneFrnd, eDesc, estreet, ecity, ecountry, eth, ecapacity, emsg);
		boolean t=livesettingpage.testLine();
		if(t)
		{
			livesettingpage.addZoneDetails();
		}
		else {
		Thread.sleep(5000);
		livesettingpage.addLine();
		Thread.sleep(5000);
		testutil.addLineSuggetionBox(EntryLine);
		Thread.sleep(5000);
		livesettingpage.exitLine();
		Thread.sleep(5000);
		testutil.exitLineSuggetionBox(exitLine);
		testutil.resetDropDown(reset);
		String check=livesettingpage.saveBtn();
		Assert.assertEquals(check, "zone details saved.");
		}
	}
	
	@Test(priority=2,dataProvider="getDataEdit")
	public void editZone(String eZone,String eZoneFrnd,String eDesc,String estreet,String ecity,String ecountry,String eth,String ecapacity,String emsg,String EntryLine,String exitLine,String reset) throws InterruptedException
	{
		Thread.sleep(6000);
		livesettingpage.zoneDetails();
		Thread.sleep(6000);
		boolean t=testutil.editZoneCheck("red");
		if(t==true)
		{
			livesettingpage.editZoneDetails("red");
			livesettingpage.detailEdit(eZone, eZoneFrnd, eDesc, estreet, ecity, ecountry, eth, ecapacity, emsg);
			livesettingpage.editAddLine();
			Thread.sleep(6000);
			testutil.editAddAndExitLineSuggetionBox(EntryLine);
			Thread.sleep(6000);
			livesettingpage.editExitLine();
			Thread.sleep(6000);
		    testutil.editAddAndExitLineSuggetionBox(exitLine);
		    Thread.sleep(6000);
			testutil.resetDropDown(reset);
			Thread.sleep(6000);
			String check=livesettingpage.update();
			Thread.sleep(6000);
			Assert.assertEquals(check,"zone details saved.");
			livesettingpage.reset();
			Thread.sleep(6000);
			livesettingpage.resetOK();
			livesettingpage.inCount();
			livesettingpage.btnYes();
		}
		else
		{
			Assert.assertEquals(true, false,"no such zone name to edit");
		}
			
	}
	
	//@Test(priority=1)
	public void deleteZone()
	{
		livesettingpage.zoneDetails();
		livesettingpage.deleteZoneDetails("Zone2");
	//	testutil.waitForElement(By.id("btnYes"), 10);
		//wait.until(ExpectedConditions.p
		String text=livesettingpage.deleteZone();
		Assert.assertEquals(text,"Zone2 is deleted.");
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
		
}
	
	


