package pageObjects;

import org.openqa.selenium.By;

public interface UploadDownloadPageObjects {
	
	By downloadButton=By.id("downloadButton");
	
	By uploadButton=By.xpath("//input[@type='file']");
	
	By uploadSuccessMsg=By.xpath("//*[text()='Updated Excel Data Successfully.']");
	

}
