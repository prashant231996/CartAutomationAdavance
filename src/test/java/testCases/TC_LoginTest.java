package testCases;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.BaseTest;
import utilities.DataProviders;
import utilities.Screenshots;

public class TC_LoginTest extends BaseTest{
	
	
	@Test(dataProvider = "loginData",dataProviderClass = DataProviders.class,groups= {"sanity"} )
	public void verify_Login_Functionality(String email,String password, String validity,Method method)
	{
		try
		{
		extentTest=extents.createTest(method.getName());	
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountLink();
		LoginPage lp=hp.clickLoginLink();
		lp.loginToApp(email, password);
		Thread.sleep(5000);
		String accountPageTitle=driver.getTitle();
		if(validity.equalsIgnoreCase("Valid"))
		{
			Assert.assertEquals(accountPageTitle, "My Account");
			lp.logOutFromApp();
		}
		else
		{
			Assert.assertEquals(accountPageTitle, "Account Login");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
