package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, 10);
		js=(JavascriptExecutor)driver;
		
	}
	
	public WebElement findElement(By ele)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		return driver.findElement(ele);
	}
	
	public void clickOn(By ele)
	{
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		findElement(ele).click();
	}
	
	public void type(By ele, String typeText)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		WebElement element=findElement(ele);
		element.clear();
		element.sendKeys(typeText);
	}
	
	public boolean isDisplayed(By ele)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			return findElement(ele).isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickElementWithJs(By ele)
	{
		WebElement element=findElement(ele);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		js.executeScript("arguments[0].click()", element);
	}
	
	//send keys using javascript executor
	public void sendKeysUsingJs(By ele,String text)
	{
		WebElement element=findElement(ele);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
	}
	
}
