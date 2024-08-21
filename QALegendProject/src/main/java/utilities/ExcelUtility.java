package utilities;

import java.io.FileInputStream;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream file;
	 static XSSFWorkbook wbook;
	 static XSSFSheet sheet;
	
	public static String getExcelStringData(int rows , int cells , String sheets) 
	{
		try
		{
		 file = new FileInputStream("C:\\Users\\Dell\\git\\QALegend\\QALegendProject\\src\\test\\resources\\TestData.xlsx");
		 wbook = new XSSFWorkbook(file);
		 sheet = wbook.getSheet(sheets);
		 XSSFRow row = sheet.getRow(rows);
		 XSSFCell cell = row.getCell(cells);
		 return cell.getStringCellValue();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Excel Sheet not found");
	}
		
	}
	
	public static String getExcelIntegerData(int rows, int cells , String sheets)
	{
		try
		{
		file = new FileInputStream("C:\\Users\\Dell\\git\\QALegend\\QALegendProject\\src\\test\\resources\\TestData.xlsx");
		wbook = new XSSFWorkbook(file);
		sheet = wbook.getSheet(sheets);
		XSSFRow row = sheet.getRow(rows);
		XSSFCell cell = row.getCell(cells);
		int x = (int) cell.getNumericCellValue();
		return String.valueOf(x);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Excel sheet not found");
		}
		
	}
}
