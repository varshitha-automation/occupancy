package com.qa.occupancy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.occupancy.base.TestBase;

public class UserSettingPage extends TestBase {
	
	public UserSettingPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='User Settings']")
	WebElement user;
	
	@FindBy(xpath="//strong[text()='User Settings']")
	WebElement userSettingBtn;
	
	@FindBy(id="upwd")
	WebElement oldPwd;
	
	@FindBy(id="npwd")
	WebElement newPwd;
	
	@FindBy(xpath="//input[@id='npwd']/parent::div/parent::div/following-sibling::div/button")
	WebElement saveBtn;

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	WebElement entryInfo;
	
	public void userClick()
	{
		user.click();
	}
	
	public void userBtnClick()
	{
		userSettingBtn.click();
	}
	
	public boolean pwdSet()
	{
		oldPwd.sendKeys("gd");
		newPwd.sendKeys("gs");
		saveBtn.click();
		if(driver.findElements(By.xpath("//div[@class='ui-pnotify-text']")).size()>0)
		{
		return true;
		}
		return false;
	}
	
	public boolean update()
	{
		oldPwd.sendKeys("gd");
		newPwd.sendKeys("gs");
		saveBtn.click();
		if(driver.findElements(By.xpath("//div[@class='ui-pnotify-text']")).size()>0)
		{
		return true;
		}
		return false;
	}
	
}
