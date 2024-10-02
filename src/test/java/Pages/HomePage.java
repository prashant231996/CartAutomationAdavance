package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObjects;

public class HomePage extends BasePage implements HomePageObjects{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public void clickMyAccountLink()
	{
		try
		{
			clickOn(myAccountLink);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public LoginPage clickLoginLink()
	{
		try
		{
			clickOn(loginLink);
			return new LoginPage(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public RegisterPage clickRegisterLink()
	{
		try
		{
			clickOn(registerLink);
			return new RegisterPage(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
