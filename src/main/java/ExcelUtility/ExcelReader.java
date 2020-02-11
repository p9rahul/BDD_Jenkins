package ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) {
		
		FileInputStream fis;
		XSSFWorkbook wb;
		XSSFSheet sheet = null;
		try {
			 String pathExcel = System.getProperty("user.dir")+ "/src/main/resources/TestData/ReadExcel.xlsx";			 
			fis = new FileInputStream(new File(pathExcel));
			 wb =new XSSFWorkbook(fis);
			 sheet=wb.getSheet("Sheet1");
		} catch (Exception e) {
			System.out.println("error in try");
		}
		
		
		int row= sheet.getLastRowNum();
		System.out.println("total rows" +row);
		short cloumn = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<row+1;i++)
		{
			for(int j=0;j<cloumn;j++)
			{
				XSSFRow rownum =sheet.getRow(i);
				String colValue = rownum.getCell(j).getStringCellValue();
				System.out.println(colValue);
			}
		}
		
	}
}
