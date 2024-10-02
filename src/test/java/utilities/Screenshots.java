package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	//Returning destination snap shot file path..
	public static String getSnapShot(WebDriver driver,String snapShotName)
	{
		try
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			String destinationFilePath=System.getProperty("user.dir")+"//screenshots//"+snapShotName+".jpg";
			File destinationFile=new File(destinationFilePath);
			FileUtils.copyFile(srcFile, destinationFile);
			return destinationFilePath;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
