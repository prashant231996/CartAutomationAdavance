package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class LoginPage extends BasePage implements LoginPageObjects, HomePageObjects{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void loginToApp(String Email, String Password)
	{
		try
		{
			type(email, Email);
			type(password, Password);
			clickOn(loginBtn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void logOutFromApp()
	{
		try
		{
			clickOn(myAccountLink);
			clickOn(logOutLink);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
