package com.qa.occupancy.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.occupancy.TestUtil.TestUtil;
import com.qa.occupancy.base.TestBase;

public class RollingDashPage extends TestBase {
	
	public RollingDashPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[@class='nav-profile-name']")
	WebElement adminBtn;
	
	@FindBy(xpath="//h4[@id='clock']")
    WebElement timeStamp;
	
	@FindBy(xpath="//div[@class='text-center navbar-brand-wrapper d-flex align-items-center justify-content-center']/h2")
	WebElement heading;
	
	@FindBy(xpath="//a[@class='dropdown-item']")
	List<WebElement> list;
	
 private void waitForVisibility(WebElement element) {
         new WebDriverWait(driver, 10)
              .until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 private void waitForVisibilityOfElements(List<WebElement> element) {    
         new WebDriverWait(driver, 10)
         .until(ExpectedConditions.visibilityOfAllElements(element));
  }
	public LiveSettingPage adminBtn()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//waitForVisibility(adminBtn);
		adminBtn.click();
		//waitForVisibilityOfElements(list);
	TestUtil testutil = new TestUtil();
	
	testutil.suggetionBox("Live Settings");
	return new LiveSettingPage();
	}
	
	public Dashboard1Page clickDash1()
	{
		adminBtn.click();
		TestUtil testutil = new TestUtil();
		testutil.suggetionBox("Dashboard 1");
		return new Dashboard1Page();
	}
	
	public Dashboard2Page clickDash2()
	{
		adminBtn.click();
		TestUtil testutil = new TestUtil();
		testutil.suggetionBox("Dashboard 2");
		return new Dashboard2Page();
	}
	
	public void Logout()
	{
		adminBtn.click();
		TestUtil testutil = new TestUtil();
		testutil.suggetionBox("Logout");
		
	}
	
	public boolean timeStamp()
	{
		boolean t = timeStamp.isDisplayed();
		return t;
	}
	
	public String heading()
	{
		String text = heading.getText();
		return text;
	}

}
