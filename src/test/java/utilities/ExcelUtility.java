package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	String filePath;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public ExcelUtility(String filePath) throws IOException
	{
		try
		{
		this.filePath=filePath;
		File excelFile=new File(filePath);
	    fis=new FileInputStream(excelFile);
	    wb=new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheetName)
	{
		int row=0;
		try
		{
			sheet=wb.getSheet(sheetName);
			row=sheet.getLastRowNum();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return row;
	}
	
	public int getColumnCount(String sheetName)
	{
		int column=0;
		try
		{
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(0);
			column=row.getLastCellNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return column;
	}
	
	public String getCellData(String sheetName,int rowNum,int colNum)
	{
		String data="";
		try
		{
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			//data=cell.getStringCellValue();
			//Using DataFormatter which will format cell value and return value of cell as String regardless of type of cell
			DataFormatter formatter=new DataFormatter();
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	

}
