package testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.BaseTest;

public class TC_AccountRegistrationTest extends BaseTest{
	
	
	@Test
	public void verify_Account_Registration()
	{
		try
		{
		logger.info("********Account Registration test cases started sucessufully.*********");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountLink();
		RegisterPage rg=hp.clickRegisterLink();
		rg.registerInApplication("Prashant", "More", randomEmailGenerator()+"@gmail.com", "12345");
		Assert.assertTrue(rg.accountRegisteredSuccessfully());
		logger.info("********Registration commpleted sucessufully.*********");
		logger.info("********Registration test cases executed successfully*********");
		}
		catch(Exception e)
		{
			//Error level logs
			logger.error(e.getMessage());
			logger.error("Test Failed..");
			//Debug level log
			logger.debug("Debug logs..");
			//As assertion got failed failing test case
			Assert.fail();
		}
	}


}
