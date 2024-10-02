package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//Log4j
import org.apache.logging.log4j.Logger;//Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportManager;
import utilities.Screenshots;

public class BaseTest {
	
	public WebDriver driver;
	public Logger logger;//Log4j
	public Properties prop;
	public static ExtentReports extents;
	public static ExtentReportManager extentReportManager;
	public static ExtentTest extentTest;
	
	@BeforeSuite(groups= {"sanity"})
	public void setUpReport()
	{
		try
		{
			extents=ExtentReportManager.getReporter();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterSuite(groups= {"sanity"})
	public void tearDownReport()
	{
		try
		{
			extents.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeClass(groups= {"sanity"})
	@Parameters({"os","browser"})
	public void setUp(String os, String browser) throws InterruptedException, IOException
	{
		//Loading config.properties file
		File propFile=new File("./src/test/resources/config.properties");
		FileInputStream fis=new FileInputStream(propFile);
		prop=new Properties();
		prop.load(fis);
		logger=LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default: System.out.println("Invalid browser name");
		    return;
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
		//Added static wait of 20 seconds it requires time to load application
		//Thread.sleep(10000);
	}
	
	@AfterClass(groups= {"sanity"})
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterMethod(groups= {"sanity"})
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS,"Test case is passed: "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, "Test case is skipped: "+result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(Status.FAIL, "Test cases is failed: "+result.getName());
			extentTest.log(Status.FAIL, "Test cases is failed: "+result.getThrowable());
			String failScreenShotPath=Screenshots.getSnapShot(driver, result.getName());
			extentTest.addScreenCaptureFromPath(failScreenShotPath);
		}
	}
	
	public String randomEmailGenerator()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}

}
