package pageObjects;

import org.openqa.selenium.By;

public interface RegisterPageObjects {
	
	public By firstName=By.id("input-firstname");
	
	public By lastName=By.id("input-lastname");
	
	public By email=By.id("input-email");
	
	public By password=By.id("input-password");
	
	public By continueBtn=By.xpath("//button[@type='submit']");
	
	public By agreeBtn=By.name("agree");
	
	public By accountConfirmationMessage=By.xpath("//h1[text()=\"Your Account Has Been Created!\"]");
	

}
