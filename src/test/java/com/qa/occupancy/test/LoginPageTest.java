package com.qa.occupancy.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.occupancy.base.TestBase;
import com.qa.occupancy.pages.LoginPage;
import com.qa.occupancy.pages.RollingDashPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	RollingDashPage rollingdashpage;
	
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	
	public void loginTest()
	{
		rollingdashpage=loginpage.login();
		
	}
	
	@Test(priority=2)
	
	public void titleTest()
	{
		String Text=loginpage.maintitle();
		Assert.assertEquals(Text,"Occupancy Dashboard","not matched");
	}
	
	@Test(priority=3)
	
	public void versionTest()
	{
		boolean l=loginpage.version();
		Assert.assertTrue(l);
	}
	
	@Test(priority=4)
	
	public void headingTest()
	{
		String head=loginpage.heading();
		Assert.assertEquals(head, "Occupancy Dashboard","not matched");
	}
		
	@Test(priority=5)
		public void logoTest()
		{
			boolean b = loginpage.Logo();
			Assert.assertTrue(b);
		}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}

}
