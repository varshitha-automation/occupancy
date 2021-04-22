package com.qa.occupancy.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.Table.Cell;
import com.qa.occupancy.base.TestBase;

public class TestUtil extends TestBase {
	
	public static String ExcelLocation="D:\\Automation Selenium\\Occupancy\\src\\main\\java\\com\\qa\\occupancy\\testdata\\testdataexcel.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void suggetionBox(String option)
	{
		List<WebElement> l= driver.findElements(By.xpath("//a[@class='dropdown-item']"));
		for(WebElement newlist : l)
		{
			String name = newlist.getText();
			if(name.contains(option))
			{
				newlist.click();
				break;
			}
		}
	}
	
	public   void addLineSuggetionBox(String option)
	{
		List<WebElement> l= driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu show']/li/a/label"));
		for(int i=0;i<l.size();i++)
		{
			String name = l.get(i).getText();
			if(name.contains(option))
			{
				l.get(i).click();
				
			}

		}
	//	List<WebElement> h=editAddAndExitLineSuggetionBox();
		
	}
	
	
	public void exitLineSuggetionBox(String option)
	{
		
		List<WebElement> l= driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu show']/li/a"));
	/*	JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", l);*/
		for(WebElement newlist : l)
		{
			String name = newlist.getText();
			if(name.contains(option))
			{
				/*JavascriptExecutor exe1 = (JavascriptExecutor)driver;
				exe1.executeScript("arguments[0].click()", newlist);*/
				newlist.click();
				break;
			}
		}
	}
	
	public static void editAddAndExitLineSuggetionBox(String option)
	{
		//String value = "";
		List<WebElement> l= driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu show']/li[@class='active']"));
	/*	JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", l);*/
		for(WebElement newlist : l)
		{
			
				JavascriptExecutor exe1 = (JavascriptExecutor)driver;
				exe1.executeScript("arguments[0].click()", newlist);
			//	newlist.click();
		}	
		List<WebElement> w= driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu show']/li/a"));   
		for(WebElement newlist : w)
		{
			String name = newlist.getText();
			if(name.contains(option))
			{
				/*JavascriptExecutor exe1 = (JavascriptExecutor)driver;
				exe1.executeScript("arguments[0].click()", newlist);*/
				newlist.click();
				break;
			}
		}
		}
	
	
	public void resetDropDown(String value)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		Select sel=new Select(driver.findElement(By.id("sel_reset")));
		sel.selectByVisibleText(value);
	}
	
	public void SMS(String value)
	{
		
		Select sel=new Select(driver.findElement(By.id("thSmsTemplate")));
		sel.selectByValue(value);
	}
	
	public Object[][] excelData(String sheetname)
	{
		FileInputStream fs=null;
		try {
			fs = new FileInputStream(ExcelLocation);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		book = WorkbookFactory.create(fs);
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i<sheet.getLastRowNum();i++)
		{
			for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				DataFormatter fmt = new DataFormatter();
				// Once per cell
				data[i][j] = fmt.formatCellValue(sheet.getRow(i+1).getCell(j));
			//	data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public boolean editZoneCheck(String name)
	{
	boolean text=driver.findElements(By.xpath("//td[text()='"+name+"']")).size()>0;
		if(text==true)
		{
			return true;
		}
		return false;
		
	}
	
	public static void ExplicitWait(WebDriver driver,List<WebElement> ele,int timeout)
	{
	   new WebDriverWait(driver, timeout).until
	            (ExpectedConditions.visibilityOfAllElements(ele));
	    
	    
	  /*  List<WebElement> elements = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elements;*/
	}
	
	public void selectCheckBox(String option)
	{
		
		List<WebElement> t=driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu show']/li[@class='active']/a/label/input"));
		ExplicitWait(driver,t,50);
		for(WebElement u : t)
		{
			if(u.isSelected())
			{
				u.click();
			}
		}
		List<WebElement> w= driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu show']/li/a"));   
		for(WebElement newlist : w)
		{
			String name = newlist.getText();
			if(name.contains(option))
			{
				/*JavascriptExecutor exe1 = (JavascriptExecutor)driver;
				exe1.executeScript("arguments[0].click()", newlist);*/
				newlist.click();
				break;
			}
		}
		
	}
	
	public String selZoneDropDown(String name)
	{
		Select sel=new Select(driver.findElement(By.id("sel_ZoneName")));
		sel.selectByVisibleText(name);
		return name;
	}
	
	public String screenShot(String filename) throws IOException
	{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination= "D:\\git projects\\occupancy\\ScreenShot\\"+filename+".png";
		//FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\ScreenShot\\"+filename+".png"));
		FileUtils.copyFile(file, new File(destination));
		return destination;
	}
	
	public ExtentReports testReport()
	{
		//String path = System.getProperty("user.dir")+"\\TestResult\\result.html";
		ExtentSparkReporter ext = new ExtentSparkReporter("D:\\git projects\\occupancy\\TestResult\\result.html");
		ext.config().setReportName("Web Automation");
		ext.config().setDocumentTitle("Occupancy Automation Results");
	    ExtentReports extent = new ExtentReports();
		extent.attachReporter(ext);
		extent.setSystemInfo("Tester","Varshitha");
		return extent;
	}
	
	

}

