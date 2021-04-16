package com.qa.occupancy.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public static void initialization() throws IOException
	{
	    prop = new Properties();
		FileInputStream fs = new FileInputStream("D:\\Automation Selenium\\Occupancy\\src\\main\\java\\com\\qa\\occupancy\\config\\config.properties");
		prop.load(fs);
		
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\user\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.geeko.driver", "D:\\user\\firefoxdriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(9, TimeUnit.SECONDS);
	}

}
