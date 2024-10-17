package testCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.UploadDownloadPage;
import testBase.BaseTest;
import utilities.ExcelUtility;

public class TC_Upload_Download_Func_Test extends BaseTest{
	
	@Test(groups= {"sanity"})
	public void testDownloadAndUploadFunctionality(Method method)
	{
		try
		{
			extentTest=extents.createTest(method.getName());
			driver.get(prop.getProperty("uploadDownloadUrl"));
			UploadDownloadPage uploadDownloadPage=new UploadDownloadPage(driver);
			//Downloading the file
			uploadDownloadPage.downloadFile();
			//Edit excel File
			//Initiating Excel Utility
			ExcelUtility excelUtility=new ExcelUtility(System.getProperty("user.dir")+"./src/test/resources/download.xlsx");
			//Updating price of apple fruite
			//Get the column no of price
			int columnNumber=excelUtility.getColumnNumberOfRespectiveHeader("tableData", "price");
			int rowNumber=excelUtility.getRowNumberOfMatchingCellValue("tableData", "Apple");
			excelUtility.updateCellData("tableData", rowNumber, columnNumber, 444);
			//Uploading the Updated downloaded file
			uploadDownloadPage.uploadTheFile();
			//Verifying upload done successfully
			uploadDownloadPage.verifyFileUploadedSuccessfully();
			uploadDownloadPage.waitUntilSuccessMsgDisapper();
			//Refresh page to load the updated content
			driver.navigate().refresh();
			//Validate updated value should show in table
			String updateActualValue=excelUtility.getCellData("tableData", rowNumber, columnNumber);
			Assert.assertEquals(Integer.parseInt(updateActualValue), 444);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
