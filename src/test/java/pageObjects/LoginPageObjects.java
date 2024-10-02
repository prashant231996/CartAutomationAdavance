package pageObjects;

import org.openqa.selenium.By;

public interface LoginPageObjects {
	
	By email=By.id("input-email");
	
	By password=By.id("input-password");
	
	By loginBtn=By.xpath("//button[text()='Login']");
	
	By logOutLink=By.linkText("Logout");

}
