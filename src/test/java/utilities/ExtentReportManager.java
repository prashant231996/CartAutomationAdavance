package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports extents;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter extentSpartReporter;
	
	
	public static ExtentReports getReporter()
	{
		try
		{
			extentSpartReporter=new ExtentSparkReporter("./reports/reportName.html");
			extentSpartReporter.config().setReportName("Open Cart Automation Report");
			extentSpartReporter.config().setDocumentTitle("Open Cart Automation Report Document");
			extentSpartReporter.config().setTheme(Theme.DARK);
			extents=new ExtentReports();
			extents.attachReporter(extentSpartReporter);
			extents.setSystemInfo("Tested By:", "Prashant Shivaji More");
			extents.setSystemInfo("OS", "Windows");
			extents.setSystemInfo("Browser","Chrome");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return extents;
	}

}
