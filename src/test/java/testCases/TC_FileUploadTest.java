package testCases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testBase.BaseTest;

public class TC_FileUploadTest extends BaseTest{
	

	@Test(priority=1,groups= {"sanity"},enabled=false)
	public void fileUploadUsingSendKeys()
	{
		try
		{
		driver.get("https://www.foundit.in/upload");
		driver.findElement(By.xpath(" //*[contains(text(),'Upload Resume') and contains(@class,'secondaryBtn__text')]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"./src/test/resources/download.xlsx");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"./src/test/resources/UploadFile.txt");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=2,groups= {"sanity"})
	public void fileUploadUsingRobotClasses()
	{
		try
		{
			driver.get("https://www.foundit.in/upload");
			driver.findElement(By.xpath(" //*[contains(text(),'Upload Resume') and contains(@class,'secondaryBtn__text')]")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"./src/test/resources/download.xlsx");
			WebElement browseButton=driver.findElement(By.xpath("//input[@type='file']"));
			//Clicking the file browse element using javascript executor
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", browseButton);
			
			//Step 1 Copy the file path into click board(Ctrl+C)
			StringSelection filePathSelection=new StringSelection("F:\\selenium\\OpenCartAutomation\\src\\test\\resources\\UploadFile.txt");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
			
			//Step 2 Ctrl+V
			Robot robot=new Robot();
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			Thread.sleep(3000);
			//Step 3 Press Enter key
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
