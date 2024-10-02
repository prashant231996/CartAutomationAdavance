package pageObjects;

import org.openqa.selenium.By;

public interface HomePageObjects {
	
	public By myAccountLink=By.xpath("//span[text()='My Account']");
	
	public By registerLink=By.linkText("Register");
	
	public By loginLink=By.linkText("Login");
	

}
