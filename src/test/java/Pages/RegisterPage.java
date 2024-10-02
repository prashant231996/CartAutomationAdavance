package Pages;

import org.openqa.selenium.WebDriver;

import pageObjects.RegisterPageObjects;

public class RegisterPage extends BasePage implements RegisterPageObjects{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerInApplication(String firstname, String lastname, String Email, String Password )
	{
		try
		{
			type(firstName,firstname);
			type(lastName,lastname);
			type(email,Email);
			type(password,Password);
			//clickOn(agreeBtn);
			//clickOn(continueBtn);
			clickElementWithJs(agreeBtn);
			clickElementWithJs(continueBtn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public boolean accountRegisteredSuccessfully()
	{
		try
		{
			return isDisplayed(accountConfirmationMessage);
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
