package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.UploadDownloadPageObjects;
import utilities.ExcelUtility;

public class UploadDownloadPage extends BasePage implements UploadDownloadPageObjects{

	public UploadDownloadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void downloadFile()
	{
		clickOn(downloadButton);
	}
	
	public void uploadTheFile()
	{
		uploadFile(uploadButton, System.getProperty("user.dir")+"/src/test/resources/download.xlsx");
	}
	
	public boolean verifyFileUploadedSuccessfully()
	{
		return isDisplayed(uploadSuccessMsg);
	}
	
	public void waitUntilSuccessMsgDisapper()
	{
		waitUntilInvisibilityOfElement(uploadSuccessMsg);
	}
	
	public void editExcelFile() throws IOException
	{
		ExcelUtility excelutility=new ExcelUtility(System.getProperty("user.dir")+"/src/test/resources/download.xlsx");
		
	}

}
