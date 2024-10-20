package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.BaseTest;

public class TC_TestToBuyTicket extends BaseTest{
	
	
	@Test(priority=1, description="Test to buy ticket from dummy application", groups= {"sanity"})
	public void ticketBuyTest()
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			String departureYear="2025";
			String departureMonth="October";
			String departureDate="23";
			String returnYear="2026";
			String returnMonth="May";
			String returnDate="23";
			
			driver.get("https://www.travanya.com/dummy-flight-ticket/");
			driver.findElement(By.xpath("//label[@for='roundtrip1']")).click();
			driver.findElement(By.cssSelector("#fromCity")).click();
			driver.findElement(By.id("fromAirport")).sendKeys("Kol");
			List<WebElement>serachItems=driver.findElements(By.xpath("//div[@class='SearchCityListBox']/descendant::Span/following-sibling::*"));
			for(WebElement item:serachItems)
			{
				if(item.getText().equalsIgnoreCase("kolhapur"))
				{
					item.click();
					break;
				}
			}
			
			driver.findElement(By.id("toCity")).click();
			driver.findElement(By.id("toAirport")).sendKeys("Pune");
			serachItems=driver.findElements(By.xpath("//div[@class='SearchCityListBox']/descendant::Span/following-sibling::*"));
			for(WebElement item:serachItems)
			{
				if(item.getText().equalsIgnoreCase("Pune"))
				{
					item.click();
					break;
				}
			}
			
			driver.findElement(By.className("DepartDateBOx")).click();
			Thread.sleep(3000);
		
			while(true)
			{
				String currantMonth=driver.findElement(By.xpath("(//div[@class='react-datepicker__month-read-view']/span)[2]")).getText();
				String currantYear=driver.findElement(By.xpath("(//div[@class='react-datepicker__year-read-view']/span)[2]")).getText();
				
				if((currantMonth.equalsIgnoreCase(departureMonth)) && (currantYear.equalsIgnoreCase(departureYear)))
				{
					break;
				}
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next Month']")));
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
				
			}
			
			//Selecting Date
			List<WebElement>dates=driver.findElements(By.xpath("(//div[@class='react-datepicker__month']/div/div/following-sibling::div)"));
			for(WebElement date: dates)
			{
				if(date.getText().equalsIgnoreCase(departureDate))
				{
					date.click();
					break;
				}
			}
			Thread.sleep(2000);
			//Return date selection
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ReturnDateBOx")));
			driver.findElement(By.cssSelector(".ReturnDateBOx h6")).click();
			Thread.sleep(100);
			while(true)
			{
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='react-datepicker__month-read-view']/span)[2]")));
				String currantMonth=driver.findElement(By.xpath("(//div[@class='react-datepicker__month-read-view']/span)[2]")).getText();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='react-datepicker__year-read-view']/span)[2]")));
				String currantYear=driver.findElement(By.xpath("(//div[@class='react-datepicker__year-read-view']/span)[2]")).getText();
				
				if((currantMonth.equalsIgnoreCase(returnMonth)) && (currantYear.equalsIgnoreCase(returnYear)))
				{
					break;
				}
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next Month']")));
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
				
			}
			
			
			//Selecting Date
		    dates=driver.findElements(By.xpath("(//div[@class='react-datepicker__month']/div/div/following-sibling::div)"));
			for(WebElement date: dates)
			{
				if(date.getText().equalsIgnoreCase(returnDate))
				{
					date.click();
					break;
				}
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Search']")));
			driver.findElement(By.xpath("//*[text()='Search']")).click();;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
