package com.qa.occupancy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.occupancy.base.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="UserName")
	WebElement username;
	
	@FindBy(id="UserPwd")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='col-lg-12 header']/h1")
	WebElement heading;
	
	@FindBy(xpath="//div[@class='col-lg-12 header']/h6")
	WebElement version;
	
	@FindBy(xpath="//img[@src='images/Logo_DefaultBlack.png']")
    WebElement Logo;
	
	
	public RollingDashPage login()
	{
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new RollingDashPage();
	}
	
	public String heading()
	{
		String text=heading.getText();
		return text;
	}
	
	public String maintitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public boolean Logo()
	{
		boolean l = Logo.isDisplayed();
		return l;
    }
	
	public boolean version()
	{
		boolean b=version.isDisplayed();
		return b;
	}

}
