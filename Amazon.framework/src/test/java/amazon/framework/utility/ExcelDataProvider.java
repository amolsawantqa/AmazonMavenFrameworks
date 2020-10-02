package amazon.framework.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src = new File("./TestData/LoginData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}catch(Exception e)
		{
			System.out.println("unable to load excel file"+e.getMessage());
		}
	}
	
	public String getStringData(int sheetindex,int row,int column)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	}
	public String getStringData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(int sheetindex,int row,int column)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getNumericCellValue();
	}
	public double getNumericData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
	
}
