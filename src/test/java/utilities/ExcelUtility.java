package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
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
	
	public void updateCellData(String sheetName, int rowNum, int colNum, int updatedData)
	{
		try
		{
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			cell.setCellValue(updatedData);
			File excelFile=new File(filePath);
		    FileOutputStream fos=new FileOutputStream(excelFile);
		    wb.write(fos);
		    fos.close();
		    wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getColumnNumberOfRespectiveHeader(String sheetName,String headerName)
	{
		int colCount;
		int colNum=0;
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(0);
			colCount=sheet.getRow(0).getLastCellNum();
			for(int i=0;i<colCount;i++)
			{
				if(row.getCell(i).getStringCellValue().equalsIgnoreCase(headerName))
				{
					
						colNum=i;
						break;
				}
			}
			
			return colNum;	
	}
	
	public int getRowNumberOfMatchingCellValue(String sheetName,String expectedCellvalue)
	{
		sheet=wb.getSheet(sheetName);
		int rowNum=getRowCount(sheetName);
		int colCount=getColumnCount(sheetName);
		int rowCount=0;
		for(int i=1;i<=rowNum;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				if(row.getCell(j).getCellType()==CellType.STRING)
				{
				if(row.getCell(j).getStringCellValue().equalsIgnoreCase(expectedCellvalue))
				{
					rowCount=i;
					break;
				}
				}
			}
		}
		return rowCount;
	}
	
	
	

}
