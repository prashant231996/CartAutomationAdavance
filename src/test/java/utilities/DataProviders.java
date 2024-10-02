package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public Object[][] getData() throws IOException
	{
	        ExcelUtility excelUtil=new ExcelUtility("F:\\selenium\\OpenCartAutomation\\src\\test\\resources\\DataLogin.xlsx");
			int rowNum=excelUtil.getRowCount("data");
			int colNum=excelUtil.getColumnCount("data");
		    Object[][]loginData=new Object[rowNum][colNum];
			for(int i=1;i<=rowNum;i++)
			{
				for(int j=0;j<colNum;j++)
				{
					loginData[i-1][j]=excelUtil.getCellData("data", i, j);
				}
			}
		return loginData;
	}

}
